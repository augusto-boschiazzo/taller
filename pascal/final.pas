program final;
const
    valorAlto = 9999;
type
    id = 1..5;
    cantidad = 0..10;
    n_esq = 1..100;

    esq = record
        avenida: n_esq;
        calle: n_esq;
        end;

    mensaje = record
        id_robot: id;
        cant_f: cantidad;
        cant_p: cantidad;
        esquina: esq;
        end;

    puntob = record
        avenida: n_esq;
        flores: cantidad;
        cero_papeles: Integer;
        end;
        
    lista = ^nodo; 
    nodo = record
        dato: mensaje;
        sig: lista;
        end;

    listab = ^nodoB;
    nodoB = record
        dato: puntob;
        sig: listab;
        end;

    vector = array[id] of lista; //cada lista de las celdas es un robot, cada nodo de la lista es un mensaje.

    arbol = ^nodoABB;
    nodoABB = record
        dato: puntob;
        HI: arbol;
        HD: arbol;
        end;

procedure insertar(var l: lista; dato: mensaje);
var
    ant, nue, act: lista;
begin
    new(nue); nue^.dato:= dato;
    act:= l;
    while (act <> nil) AND (dato.esquina.avenida > act^.dato.esquina.avenida) do begin
        ant:= act;
        act:= act^.sig;
    end;
    if (act = l) then
        l:= nue
    else
        ant^.sig:= nue;
    nue^.sig:= act;
end;

procedure insertarB(var l: listab; dato: puntob);
var
    ant, nue, act: listab;
begin
    new(nue); nue^.dato:= dato;
    act:= l;
    while (act <> nil) AND (dato.avenida > act^.dato.avenida) do begin
        ant:= act;
        act:= act^.sig;
    end;
    if (act = l) then
        l:= nue
    else
        ant^.sig:= nue;
    nue^.sig:= act;
end;

procedure insertarABB(var a: arbol; dato: puntob);
var
    nue: arbol;
begin
    new(nue); nue^.dato:= dato; nue^.HI:= nil; nue^.HD:= nil;
    if (a = nil) then
        a:= nue
    else if (nue^.dato.flores < a^.dato.flores) then
        insertarABB(a^.HI, dato)
    else
        insertarABB(a^.HD, dato); 
end;

procedure recibirMensajes(var v: vector);
var
    dato: mensaje;
    i: Integer;
begin
    for i:= 1 to 100 do begin
        dato.id_robot:= random(5) +1;
        dato.cant_f:= random(11);
        dato.cant_p:= random(11);
        dato.esquina.avenida:= random(100) +1;
        dato.esquina.calle:= random(100) +1;
        insertar(v[dato.id_robot], dato);
    end;
end;

procedure calcularMinimo(v: vector; var min, minimo: Integer);
var
    i: Integer;
begin
    minimo:= valorAlto;
    for i:= 1 to 5 do begin
        if (v[i]^.dato.esquina.avenida < minimo) then begin
            minimo:= v[i]^.dato.esquina.avenida;
            min:= i;
        end;
    end;
    writeln(minimo);
end;

procedure mergeAcumulador(v: vector; var l: listab);
var
    dato: puntob;
    total_flor, total_papel, min, minimo: Integer;
begin
    total_papel:= 0;
    minimo:= valorAlto;
    calcularMinimo(v, min, minimo);
    while (minimo <> valorAlto) do begin
        total_flor:= 0;
        while (v[min]^.dato.esquina.avenida = minimo) do begin
            total_flor:= total_flor + v[min]^.dato.cant_f;
            if (v[min]^.dato.cant_p = 0) then
                total_papel:= total_papel +1;
            v[min]:= v[min]^.sig;
        end;
        dato.avenida:= minimo;
        dato.flores:= total_flor;
        dato.cero_papeles:= total_papel;
        calcularMinimo(v, min, minimo);
        insertarB(l, dato);
    end;
end;

procedure crearABB(l: listab; var a: arbol);
begin
    if (l <> nil) then
        crearABB(l^.sig, a)
    else
        insertarABB(a, l^.dato);
end;

var
    v: vector;
    l: listab;
    a: arbol;
begin
    recibirMensajes(v);
    mergeAcumulador(v, l);
    crearABB(l, a);  
end.
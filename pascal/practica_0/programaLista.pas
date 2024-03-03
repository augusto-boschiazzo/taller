program ProgramaLista;
type
    lista = ^nodo;
    nodo = record
        dato: integer;
        sig: lista;
        end;

procedure agregarAtras(var l, ult: lista; dato: integer);
var
    aux: lista;
begin
    new(aux); aux^.dato:= dato; aux^.sig:= nil;
    if (l = nil) then begin
        l:= aux;
        ult:= l;
    end
    else begin
        ult^.sig:= aux;
        ult:= aux;
    end;
end;

procedure insertarEnLista(var l: lista; dato: Integer);
var 
    nue, ant, act: lista;
begin
    new(nue); nue^.dato:= dato;
    act:= l;
    while (act <> nil) AND (dato > act^.dato) do begin
        ant:= act;
        act:= act^.sig;
    end;
    if (act = l) then 
        l:= nue
    else
        ant^.sig:= nue;
    nue^.sig:= act;
end;

procedure impLista(l: lista);
begin
    if (l <> nil) then begin
        write(l^.dato, ' ');
        impLista(l^.sig);
    end;
end;

function borrarElem(var l: lista; n: Integer): boolean;
var
    ant, act: lista;
    aux: boolean;
begin
    aux:= false;
    act:= l;
    while (act <> nil) AND (act^.dato < n) do begin
        ant:= act;
        act:= act^.sig;
    end;
    if(act <> nil) then begin
        aux:= true;
        if (act = l) then
            l^.sig:= act^.sig
        else
            ant^.sig:= act^.sig;
        dispose(act);
    end;
    borrarElem:= aux;
end;

procedure crearLista(var l: lista);
var
    n: integer;
begin
    readln(n);
    while(n <> -1) do begin
        insertarEnLista(l, n);
        readln(n);
    end;
end;

var
    l: lista;
begin
    crearLista(l);
    impLista(l);
    writeln(borrarElem(l, 3));
    impLista(l);
    writeln;
end.
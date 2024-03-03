program ej1;

var num, ing, cant: integer;


begin
    Randomize;
    ing:= 1;
    cant:= 0;
    while (ing <> 0) do
    begin
        num:= random (100);
        readln(ing);
        writeln('El numero aleatorio es: ', num);
        if (num = ing) then
            cant:= cant +1;
    end;
    writeln('Cantidad de veces que coincidieron: ', cant);
end.
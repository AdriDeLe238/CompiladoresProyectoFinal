package proyect;
import static proyect.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
salto=[\n]+

%{
    public String lexeme;
%}

%%
program |
int |
fi |
until |
read |
write |
bool |
not |
and |
or |
float |
string |
if |
else |
switch |
case |
break |
do |
then |
fi |
while {lexeme=yytext(); return Reservadas;}
{salto} {return Salto;}
"//".* {/*Ignore*/}
"/*".* {/*Ignore*/}
"=" {return Igual;}
"+" {return Suma;}
"-" {return Resta;}
"*" {return Multiplicacion;}
"/" {return Division;}
"==" {return igualigual;}
"<=" {return menorigual;}
">=" {return mayorigual;}
"<" {return menor;}
">" {return mayor;}
"!=" {return diferenteigual;}
";" {return puntoycoma;}
"(" {return abreparentesis;}
")" {return cierraparentesis;}
"{" {return abrellave;}
"}" {return cierrallave;}
"true" {return truel;}
"false" {return falsel;}
"NOT" {return not;}
"AND" {return and;}
"OR" {return or;}
"," {return coma;}

{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
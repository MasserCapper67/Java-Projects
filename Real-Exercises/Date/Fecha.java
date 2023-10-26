public class Fecha{
    private int dia;
    private int mes;
    private int año;


    public Fecha(int dia, int mes, int año){
        if (comprobarFecha(dia, mes, año)){
            this.dia = dia;
            this.mes = mes;
            this.año = año;
        }else{
            System.out.println("Fecha introducida incorrecta. Se inicializará el programa con la fecha estándar (1/1/1900)");
            this.dia = 1;
            this.mes = 1;
            this.año = 1900;
        }
    }

    public static boolean bisiesto(int anyo){
        return ((anyo % 4 == 0) && (anyo % 100 != 0)) || (anyo % 400 == 0);
    }
    public static boolean comprobarFecha(int dia, int mes, int agno){
        if (agno > 1900 && mes >= 1 && mes <= 12){
            int[]diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (bisiesto(agno)){
                diasPorMes[2] = 29;
            }
            return dia >= 1 && dia <= diasPorMes[mes];
        }else return false;
    }

    //Getters
    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAño(){
        return año;
    }
    public Fecha copia(){
        return new Fecha(this.dia, this.mes, this.año);
    }
    public void siguienteDia(){
        switch (mes){
            case 1: case 3: case 5: case 7: case 8: case 10:
                if (dia < 31){
                    dia++;
                }else{
                    dia = 1;
                    mes++;
                }
                break;
            case 4: case 6: case 9: case 11:
                if (dia < 30){
                    dia++;
                }else{
                    dia = 1;
                    mes++;
                }
                break;
            case 2:
                if (bisiesto(año) && (dia < 29)) {
                    dia++;
                }else if (!bisiesto(año) && dia < 28){
                    dia++;
                }else{
                    dia = 1;
                    mes = 3;
                }
                break;
            case 12:
                if (dia < 31){
                    dia++;
                }else{
                    dia = 1;
                    mes = 1;
                    año++;
                }
                break;
        }
    }

    public boolean posteriorA(Fecha otraFecha){
        if (año > otraFecha.año){
            return true;
        }else if (año == otraFecha.año){
            if (mes > otraFecha.mes){
                return true;
            }else if (mes == otraFecha.mes){
               return dia > otraFecha.dia;
            }
        }
        return false;
    }

    public boolean esBisiesto(){
        return bisiesto(año);
    }

    public String imprimir(){
        return String.format("%02d/%02d/%04d", dia, mes, año);
    }
}
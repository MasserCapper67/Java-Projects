public class Agenda{
    private String mes;
    private Cita[] citas;
    private int numeroCitas;

    public Agenda(String mes, int maximoCitas){
        this.mes = mes;
        this.citas = new Cita[maximoCitas];
    }

    public Agenda(String mes){
        this.mes = mes;
        this.citas = new Cita[50];
    }

    public void mostrarAgenda(){
        Agenda agenda = new Agenda(mes);
        System.out.println(mes + ": ");
        for (int i = 1; i <= citas.length; i ++){
            System.out.println(i + ". " + agenda.toString());
        }
    }

    public void mostrarCitasDia(int dia){
        System.out.println(dia + "del mes " + mes + ": ");
        int posicion = 0;
        for (int i = 0; i < numeroCitas; i ++){
            if(dia == citas[i].getDia()){
                posicion++;
            }
            System.out.println(" " + posicion + ", " + citas[i].toString());
        }
    }
    public boolean insertarCita(Cita cita){
        boolean result = false;
        if (numeroCitas >= citas.length) {
            result = false;
        } else {
            citas[numeroCitas] = cita;
            numeroCitas++;
            result =  true;
        }
        return result;
    }
    public boolean eliminaCita(int posicion){
        boolean result = false;
        if (posicion >= 1 && posicion <= numeroCitas){
            for (int i = posicion - 1; i < numeroCitas - 1; i++){
                citas[i] = citas[i + 1];
            }
            citas[numeroCitas - 1] = null;
            numeroCitas--;
            result = true;
        }
        return result;
    }

    public int getNumeroCitasPaciente(String paciente){
        int resultado = 0;
        for (int i = 1; i < numeroCitas; i++){
            if(paciente.equals(citas[i].getPaciente())){
                resultado++;
            }
        }
        return resultado;
    }
}
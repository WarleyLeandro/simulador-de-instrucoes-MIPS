public class PC {
    public Boolean fim = false;
    public int total = 0;

    Register reg = new Register();

    public void buscaMemoria(Boolean fim) {

        if (!fim) {
            this.total += 4;
            reg.limpaDados();
        } else {
            System.out.println("Registrador em utilização");
        }
    }
}

//c
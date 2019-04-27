package starwars;

public abstract class HarciGep {
    private int energiaszint;
    private final int tuzero;
    
    public HarciGep(int energiaszint,int tuzero){
       this.energiaszint = energiaszint;
       this.tuzero = tuzero;
    }

    public int getEnergiaszint() {
        return energiaszint;
    }

    public void setEnergiaszint(int energiaszint) {
        this.energiaszint = energiaszint;
    }

    public int getTuzero() {
        return tuzero;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" Energiaszintje: ").append(energiaszint).append("\tTűzereje: ").append(tuzero);
        return sb.toString();
    }
    
}

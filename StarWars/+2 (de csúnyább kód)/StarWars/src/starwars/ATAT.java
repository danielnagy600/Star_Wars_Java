package starwars;

public class ATAT extends HarciGep implements Fegyver ,Jarmu {
    private final int sebesseg;
    private int tavolsag;
    
    public ATAT(int energiaszint,int tuzero,int sebesseg,int tavolsag){
        super(energiaszint,tuzero);
        this.sebesseg = sebesseg;
        this.tavolsag = tavolsag;
    }
    
     public int getTavolsag() {
        return tavolsag;
    }
    
    @Override
    public void tuzel(HarciGep gep){
        setEnergiaszint(getEnergiaszint()- gep.getTuzero());
    }
    @Override
    public void mozog(){
           if(tavolsag-sebesseg>=0) tavolsag-=sebesseg;
           else tavolsag=0;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Gép típusa: ATAT\t");
        sb.append(super.toString());
        return sb.toString();
    }
}

package starwars;

public class PTower extends HarciGep implements Fegyver {
    
    public PTower(int energiaszint,int tuzero){
        super(energiaszint, tuzero);
    }
    
    @Override
    public void tuzel(HarciGep gep){
        setEnergiaszint(getEnergiaszint()-gep.getTuzero());
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Gép típusa: PTower\t");
        sb.append(super.toString());
        return sb.toString();
    }
}

package starwars;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class StarWars {
    private ArrayList <ATAT> ATATList = new ArrayList<>();
    private ArrayList <PTower> PTowerList = new ArrayList<>();
    
    public static void main(String[] args) {
       
        ATAT at1 = new ATAT(120,15,6,240);  
        ATAT at2 = new ATAT(120,15,6,360); 
        ATAT at3 = new ATAT(120,15,6,390);
        ATAT at4 = new ATAT(120,15,6,300);
        
        PTower pt1 = new PTower(180,12);
        PTower pt2 = new PTower(180,12);
        PTower pt3 = new PTower(180,12);
        PTower pt4 = new PTower(180,12);
        
        StarWars sw = new StarWars();
        
        sw.addATAT(at1);
        sw.addATAT(at2);
        sw.addATAT(at3);
        sw.addATAT(at4);
        
        sw.addPTower(pt1);
        sw.addPTower(pt2);
        sw.addPTower(pt3);
        sw.addPTower(pt4);
        try {
            sw.osszecsapas();
        } catch (FileNotFoundException ex1) {
            System.out.print("A fájl írása során hiba lépett fel.\nHIBA:"+ ex1);
        }catch(IOException ex2){
            System.out.print("A fájl írása során hiba lépett fel.\nHIBA:"+ ex2 );
        }
    }
    public void addATAT(ATAT at){
        ATATList.add(at);
    }
    public void addPTower(PTower pt){
        PTowerList.add(pt);
    }
    public void osszecsapas() throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream("C:\\Users\\Nagycsalad\\Desktop\\csata.txt"); 
        int generaltBirodalmiObjIndex;
        int generaltLazadoObjIndex;
        int bejutottATAT=0;
         Set<ATAT> halmaz = new HashSet<>();
         
        while(!ATATList.isEmpty() && !PTowerList.isEmpty() && bejutottATAT<2){
            generaltBirodalmiObjIndex = (int) (Math.random() * (ATATList.size()));
            generaltLazadoObjIndex = (int) (Math.random() * (PTowerList.size()));
            
                ATAT aktBirodalmiATAT =ATATList.get(generaltBirodalmiObjIndex);
                aktBirodalmiATAT.mozog();
                if(aktBirodalmiATAT.getTavolsag()<=0 ){
                    if(bejutottATAT==0){
                        halmaz.add(aktBirodalmiATAT);
                        bejutottATAT++;
                    }
                    else if(bejutottATAT==1 && !(halmaz.contains(aktBirodalmiATAT)))bejutottATAT++;
                }
                
                PTower aktLazado = PTowerList.get(generaltLazadoObjIndex);
   
                aktBirodalmiATAT.tuzel(aktLazado);
                aktLazado.tuzel( aktBirodalmiATAT);
                
                byte egysor [] =  aktBirodalmiATAT.toString().getBytes();
                fout.write(egysor);
                fout.write("\r\n".getBytes());
                egysor = aktLazado.toString().getBytes();
                fout.write(egysor);
                fout.write("\r\n".getBytes());
                
                System.out.println(generaltBirodalmiObjIndex + ". " + aktBirodalmiATAT);
                System.out.println(generaltLazadoObjIndex + ". "  + aktLazado);
                
                                
                if(aktBirodalmiATAT.getEnergiaszint()<=0){
                    fout.write("Az ATAT megsemmisült\r\n".getBytes());
                    ATATList.remove(aktBirodalmiATAT);
                    
                }
                if(aktLazado.getEnergiaszint()<=0){
                    fout.write("A PTower megsemmisült\r\n".getBytes());
                    PTowerList.remove(aktLazado);
                }
        }
        
        if(ATATList.isEmpty())fout.write("A Lázadók nyertek".getBytes());
        else fout.write("A Birodalmiak nyertek".getBytes());
        fout.close();
    }
}

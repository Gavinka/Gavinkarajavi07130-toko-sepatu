package Entity;
public class DaftarPembeliEntity {
   private PembeliEntity pembeli; 
    private boolean isVerified;
    private int indexSepatu; 
     public DaftarPembeliEntity(int indexSepatu,
             PembeliEntity pembeli, boolean isVerified) { 
         this.indexSepatu = indexSepatu;
        this.pembeli = pembeli;
        this.isVerified = isVerified;
    }
    public PembeliEntity getPembeli() {
        return pembeli;
    }
    public boolean isIsVerified() {
        return isVerified;
    }
    public int getIndexSepatu() {
        return indexSepatu;
    }
    public void setPembeli(PembeliEntity pembeli) {
        this.pembeli = pembeli;
    }
    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
    public void setIndexSepatu(int indexSepatu) {
        this.indexSepatu = indexSepatu;
    }
}

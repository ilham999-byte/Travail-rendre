
package devpackage;

public class DevData {
  private String developpeur;
  private String jour;
  private int nbrscripts;

  public DevData() {
  }
  public DevData (String developpeur,String jour,int nbrscripts) {
  this.developpeur = developpeur;
  this. jour = jour;
  this. nbrscripts = nbrscripts;
  }
  public String getDeveloppeur () {
  return developpeur;
  }
  public void setDeveloppeur (String developpeur) {
  this. developpeur = developpeur;
  }
  public String getJour () {
  return jour;
  }
  public void setJour (String jour) {
  this. jour = jour;
  }

  public int getNbrscripts() {
  return nbrscripts;
  }
  public void setNbrscripts (int nbrscripts) {
  this. nbrscripts = nbrscripts;
  }
  
}
    


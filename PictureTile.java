package Lab3;

public abstract class PictureTile extends Tile {
  private String name;

  public PictureTile(String name){
    this.name = name;
    setToolTipText(toString());
  }


  public String toString(){
    return this.name;
  }
}

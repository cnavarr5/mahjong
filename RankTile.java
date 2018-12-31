package Lab3;

public abstract class RankTile extends Tile {
  protected int rank;

  public RankTile(int rank){
    this.rank = rank;
    setToolTipText(toString());
  }

  @Override
  public boolean matches(Tile other){
    if(!super.matches(other)){return false;}
    RankTile otherRank = (RankTile) other;
    if(this.rank == otherRank.rank){return true;}
    else return false;
  }
}

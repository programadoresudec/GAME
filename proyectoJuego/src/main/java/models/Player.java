package models;

/**
 */
public class Player
{
   private String name;
   private String country;
   private int score;

    public Player(String name, String country) 
    {
        this.name = name;
        this.country = country;
    }

    public Player(int score) {
        this.score = score;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) 
    {
        this.country = country;
    }

    /**
     * @return the score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) 
    {
        this.score = score;
    }

    @Override
    public String toString() 
    {
        return "\nName: " + name + "\nCountry:" + country + "\nScore:" + score;
    }
    
}

public class Pakudex {
    //init vars
    private Pakuri[] pakudex;

    //constructors
    public Pakudex(){
        pakudex = new Pakuri[20];
    }

    public Pakudex(int capacity){
        pakudex = new Pakuri[capacity];
    }

    //getters
    public int getSize(){
        int size = 0;
        for(Pakuri p: pakudex) {
            if (p != null)
                size++;
        }
        return size;
    }

    public int getCapacity(){
        return pakudex.length;
    }

    //returns string array of species
    public String[] getSpeciesArray(){
        if (getSize() == 0)
            return null;
        String[] speciesArray = new String[getSize()];
        for(int i = 0; i<speciesArray.length; i++){
            speciesArray[i] = pakudex[i].getSpecies();
        }
        return speciesArray;
    }

    //returns stats given species
    public int[] getStats(String species){
        int[] statArray = new int[3];
        Pakuri pakToFind = null;
        if(getSize() != 0) {
            for (int i = 0; i< getSize(); i++) {
                if (species.equals(pakudex[i].getSpecies())) {
                    pakToFind = pakudex[i];
                    statArray[0] = pakToFind.getAttack();
                    statArray[1] = pakToFind.getDefense();
                    statArray[2] = pakToFind.getSpeed();
                    return statArray;
                }
            }
        }
    return null;
    }
    //sorts pakuri in pakudex
    public void sortPakuri(){
        Pakuri[] dest = new Pakuri[pakudex.length ];

        for( int i = 0 ; i < getSize() ; i++ )
        {
            Pakuri next = pakudex[ i ];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 )
            {
                //compares and inserts
                if( next.getSpecies().compareTo(dest[k-1].getSpecies()) > 0 )
                {
                    insertIndex = k;
                }
                else
                {
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[ insertIndex ] = next;
        } // end of for

        //copy to other
        for(int i = 0; i < dest.length; i++)
            pakudex[i] = dest[i];
        System.out.println("Pakuri have been sorted!");
    }
    //add pakuri
    public boolean addPakuri(String species){
        if(getSize() == 0) {
            pakudex[0] = new Pakuri(species);
            System.out.println("Pakuri species " + species + " successfully added!");
            return true;
        }
        //check if duplicate species
        for (int i = 0; i< getSize(); i++) {
            if (species.equals(pakudex[i].getSpecies())) {
                System.out.println("Error: Pakudex already contains this species!");
                return false;
            }
        }
        //add when array has elements
        for (int i = 0; i<pakudex.length; i++) {
            if (pakudex[i] == null) {
                pakudex[i] = new Pakuri(species);
                System.out.println("Pakuri species " + species + " successfully added!");
                return true;
            }
        }
        return false;
    }
    //evolves species
    public boolean evolveSpecies(String species){
        Pakuri pakToFind = null;
            for (int i = 0; i< getSize(); i++) {
                if (species.equals(pakudex[i].getSpecies()))
                    pakToFind = pakudex[i];
            }
        //checks if species exist
        if(pakToFind == null) {
            System.out.println("Error: No such Pakuri!");
            return false;
        }
        //otherwise evolves species
        else {
            pakToFind.evolve();
            System.out.println(species + " has evolved!");
            return true;
        }
    }
}

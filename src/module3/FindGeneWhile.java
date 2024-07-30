package module3;

public class FindGeneWhile {
    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf("TAA", startIndex + 3);

        while (currIndex != -1) {
            if ((currIndex-startIndex) % 3 ==0) {
                return dna.substring(startIndex, currIndex+3);
            } else {
            currIndex = dna.indexOf("TAA", currIndex + 1);
            }
        }
        return "";
    }

    public void testFindGeneSimple() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGene(dna);
        System.out.println("Gene is "+ gene);

        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is "+ gene);

        dna = "AATGCGTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is "+ gene);

        dna = "AATGCGTAATATGGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is "+ gene);

        dna = "AATGCGTAATATGGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is "+ gene);
    }
}

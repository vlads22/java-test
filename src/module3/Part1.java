package module3;

public class Part1 {

    public String findSimpleGene(String dna){

        String startCodon = "ATG";
        String stopCodon = "TAA";

        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) {
            return "";
        }

        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
        if (stopIndex == -1) {
            return "";
        }

        if ((stopIndex-startIndex) % 3 == 0) {
            return dna.substring(startIndex, stopIndex + 3);
        }
        else {
            return "";
        }
    }

    public void testSimpleGene() {
        String dnaWithNoATG = "AATGCGTAATATGGT";
        String dnaWithNoTAA = "AATGCTAGGGTAATATGGT";
        String dnaWithNoATGAndTAA = "AATGCGTAGGGTAATATGGT";
        String dnaWithATGAndTAAAndMultipleOf3 = "AATGCGTAATATGGTAA";
        String dnaWithATGAndTAANotMultipleOf3 = "AATGCGTAATATGGTAA";

        System.out.println("DNA strand is "+ dnaWithNoATG);
        String gene = findSimpleGene(dnaWithNoATG);
        System.out.println("Gene is " + gene);

        System.out.println("DNA strand is "+ dnaWithNoTAA);
        gene = findSimpleGene(dnaWithNoTAA);
        System.out.println("Gene is " + gene);

        System.out.println("DNA strand is "+ dnaWithNoATGAndTAA);
        gene = findSimpleGene(dnaWithNoATGAndTAA);
        System.out.println("Gene is " + gene);

        System.out.println("DNA strand is "+ dnaWithATGAndTAAAndMultipleOf3);
        gene = findSimpleGene(dnaWithATGAndTAAAndMultipleOf3);
        System.out.println("Gene is " + gene);

        System.out.println("DNA strand is "+ dnaWithATGAndTAANotMultipleOf3);
        gene = findSimpleGene(dnaWithATGAndTAANotMultipleOf3);
        System.out.println("Gene is " + gene);

    }
}

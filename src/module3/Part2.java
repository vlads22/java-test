package module3;

public class Part2 {

    public String findSimpleGene(String dnaStrand, String startCodon, String stopCodon) {

        int startIndex = dnaStrand.indexOf(startCodon);
        if (startIndex == -1) {
            return "";
        }

        int stopIndex = dnaStrand.indexOf(stopCodon, startIndex + 3);
        if (stopIndex == -1) {
            return "";
        }

        if ((stopIndex - startIndex) % 3 == 0) {
            String gene = dnaStrand.substring(startIndex, stopIndex + 3);

            if (dnaStrand == dnaStrand.toLowerCase()) {
                return gene.toLowerCase();
            } else if (dnaStrand == dnaStrand.toUpperCase()) {
                return gene.toUpperCase();
            } else {
                return gene;
            }

        } else {
            return "";
        }
    }

    public void testSimpleGene() {
            String dnaWithNoATG = "AATGCGTAATATGGT";
            String dnaWithNoTAA = "AATGCTAGGGTAATATGGT";
            String dnaWithNoATGAndTAA = "AATGCGTAGGGTAATATGGT";
            String dnaWithATGAndTAAAndMultipleOf3 = "AATGCGTAATATGGTAA";
            String dnaWithATGAndTAANotMultipleOf3 = "AATGCGTAATATGGTAA";

            String startCodon = "ATG";
            String stopCodon = "TAA";

            System.out.println("DNA strand is "+ dnaWithNoATG);
            String gene = findSimpleGene(dnaWithNoATG, startCodon, stopCodon);
            System.out.println("Gene is " + gene);

            System.out.println("DNA strand is "+ dnaWithNoTAA);
            gene = findSimpleGene(dnaWithNoTAA, startCodon, stopCodon);
            System.out.println("Gene is " + gene);

            System.out.println("DNA strand is "+ dnaWithNoATGAndTAA);
            gene = findSimpleGene(dnaWithNoATGAndTAA, startCodon, stopCodon);
            System.out.println("Gene is " + gene);

            System.out.println("DNA strand is "+ dnaWithATGAndTAAAndMultipleOf3);
            gene = findSimpleGene(dnaWithATGAndTAAAndMultipleOf3, startCodon, stopCodon);
            System.out.println("Gene is " + gene);

            System.out.println("DNA strand is "+ dnaWithATGAndTAANotMultipleOf3);
            gene = findSimpleGene(dnaWithATGAndTAANotMultipleOf3, startCodon, stopCodon);
            System.out.println("Gene is " + gene);

        }

    }


import java.io.*;

public class P2_Blood_Distribution {
    // NOTE: Problem takes input from command line
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] bloodUnits = br.readLine().split(" ");
        String [] patients = br.readLine().split(" ");

        if (bloodUnits.length != 8 || patients.length != 8) {
            System.out.println("Error, was expecting 8 blood types for blood units and patients");
            return;
        }

        System.out.println((new patientCalculator(bloodUnits, patients)).maxPatients());

    }
}


// Helper object to calculate the max patients
class patientCalculator {
    int [] bloodUnits = new int[8];
    int [] patients = new int[8];

    public patientCalculator( String [] bloodUnits, String[] patients) {
        for (int i = 0; i < 8; i++) {
            this.bloodUnits[i] = Integer.parseInt(bloodUnits[i]);
            this.patients[i] = Integer.parseInt((patients[i]));
        }
    }

    public int maxPatients () {
        int maxPatients = 0;

        // take from your own blood type
        for (int i = 0; i < 8; i++) {
            maxPatients+= patientsHelped(i, i);
        }

        // take from corresponding negative
        for (int i = 0; i < 4; i++) {
            maxPatients+= patientsHelped(2*i, 2*i+1);
        }

        // take from other blood types
        // do type A blood
        maxPatients += patientsHelped(0, 2)
                    + patientsHelped(1, 3)
                    + patientsHelped(0, 3);
        // do type B blood
        maxPatients += patientsHelped(0, 4)
                    + patientsHelped(1, 5)
                    + patientsHelped(0, 5);
        // do type AB blood
        maxPatients += patientsHelped(0, 6)
                    + patientsHelped(2, 6)
                    + patientsHelped(4, 6)
                    + patientsHelped(0, 7)
                    + patientsHelped(1, 7)
                    + patientsHelped(5, 7)
                    + patientsHelped(4, 7)
                    + patientsHelped(3, 7)
                    + patientsHelped(2, 7);

        return maxPatients;
    }

    private int patientsHelped(int bloodIdx, int patientIdx) {
        int patientsHelped = Math.min(bloodUnits[bloodIdx], patients[patientIdx]);
        bloodUnits[bloodIdx] -= patientsHelped;
        patients[patientIdx] -= patientsHelped;
        return patientsHelped;
    }
}

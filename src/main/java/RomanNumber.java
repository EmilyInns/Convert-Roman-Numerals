public class RomanNumber {

    private String number1;
    private String number2;
    private int number3;

    public RomanNumber(String number1, String number2, int number3){
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    public RomanNumber(){}

    public int combineNumbers(){
        return convertNumber(this.getNumber1())+convertNumber(this.getNumber2())+this.getNumber3();
    }

    public int convertNumber(String number){
        if (number.length() == 1) {return convertSingleChar(number); }
        else{return convertMultipleChars(number);}

    }

    private void returnError(){
        System.out.println("Error! Please only enter valid roman numerals!");
        throw new NumberFormatException();
    }

    private int convertSingleChar(String number){
        switch (number) {
            case "I":
                return 1;
            case "V":
                return 5;

            case "X":
                return 10;

            case "L":
                return 50;

            case "C":
                return 100;

            case "D":
                return 500;

            case "M":
                return 1000;

            default:
                returnError();
                return 0;
        }
    }

    private int convertMultipleChars(String number) {
        //Create array to store individual number-parts in
        int[] numParts = new int[number.length()];
        //Go through string and convert each char, adding it to the array
        for (int i = 0; i < number.length(); i++) {
            numParts[i] = convertSingleChar(String.valueOf(number.charAt(i)));
        }
        int sum = 0;
        for (int i = 0; i < numParts.length; i++) {
            if(i != numParts.length-1 && i != numParts.length ){
                if (numParts[i]>= numParts[i+1]){ sum+=numParts[i]; }
                else{ sum+= numParts[i+1]-numParts[i];
                    i++;
            }
            }
            else{sum+=numParts[i];}
        }
        return sum;
    }

    public String getNumber1() {
        return number1;
    }

    public String getNumber2() {
        return number2;
    }

    public int getNumber3() {
        return number3;
    }
}

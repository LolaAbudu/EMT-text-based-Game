package org.pursuit;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Scanner;

public class Homework2 implements StartPlay {
    Scanner scanner = new Scanner(System.in);

    int score = 100;

    @Override
    public void logoAndInstruction() {
        System.out.println(":::::::::: ::::    :::: :::::::::::\n" +
                ":+:        +:+:+: :+:+:+    :+:    \n" +
                "+:+        +:+ +:+:+ +:+    +:+    \n" +
                "+#++:++#   +#+  +:+  +#+    +#+    \n" +
                "+#+        +#+       +#+    +#+    \n" +
                "#+#        #+#       #+#    #+#    \n" +
                "########## ###       ###    ###    ");
        System.out.println("\nEmergency Medical Technician Assessment Game");
        System.out.println("Experience a daily life of an EMT!" + "\n \nThe " +
                "purpose of this game is to give you an insight on what a day " +
                "in the life of an EMT could possibly be. \nAt the end you will receive " +
                "an analysis based on the path you choose.\n " +
                "\nTo begin enter 'Yes', to end press 'No'!");
    }

    @Override
    public void startPlay() {
        String userInput;
       for (int counter = 0; counter < 3; counter++) {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("YES")) {
                System.out.println("\nOMG here we go!");  //put smiley face here
                startQuestion();
            } else if (userInput.equals("NO")) {
                System.out.println("Your loss!");
                break;
            } else {
                System.out.println("Sorry, must type 'Yes' or 'No'!");
                System.out.println("You have only " + (2 - counter) + " chances left to choose correctly");
            }
        }
    }

    public void startQuestion() {
        String userInput;
        System.out.println("\nYou are an EMT, you received a call from your dispatch to head " +
                "to a location 10 minutes away. \nAs you arrive, you see a female patient who is conscious " +
                "but short of breath and struggling to breathe. \nDo you: " +
                "\na) Perform a 'Heimlich' maneuver  " +
                "\nb) Give him 'Oxygen' ");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("OXYGEN")) {
                score = 100;
                oxygen();
            } else if (userInput.equals("HEIMLICH")) {
                score = score - 10;
                heimlich();
            } else {
                System.out.println("Sorry, must type either 'Oxygen' or 'Heimlich' ");
            }
        } while (true);
    }

    public void oxygen() {
        String userInput;
        System.out.println("\nNow your patient is breathing appropriately but " +
                "suddenly... Smack! you've been slapped across the face. \nDo you: " +
                "\na) 'Slap' back " +
                "\nb) Call the 'Cops' ");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("SLAP")) {
                score = score - 40;
                slapBack();
            } else if (userInput.equals("COPS")) {
                callCops();
            } else {
                System.out.println("Sorry, must type either 'Slap' or 'Oxygen' ");
            }
        } while (true);
    }

    public void heimlich() {
        String userInput;
        System.out.println("\nYour patient is struggling even harder to breathe " +
                "now and you become frazzled!" + "\nDo you: " +
                "\na) Call your 'Supervisor' " +
                "\nb) Deal with it 'Alone' ");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("SUPERVISOR")) {
                supervisor();
            } else if (userInput.equals("ALONE")) {
                score = score - 40;
                dealAlone();
            } else {
                System.out.println("Sorry, must type either 'Supervisor' or 'Alone' ");
            }
        } while (true);
    }


    public void slapBack() {
        String userInput;
        System.out.println("\nWelp! you might as well surrender your chances now." +
                "\nI would suggest not wasting your time but if you would like to " +
                "increase your chances, type 'Continue' \nor type 'End' to get your Analysis.");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("CONTINUE")) {
                //score = score;
                ifSlapBackContinue();
            } else if (userInput.equals("END")) {
                System.out.println("\n" + scoreResult().get(score));
                playAgain();
            } else {
                System.out.println("Please type 'Continue' ");
            }
        } while (true);
    }

    public void ifSlapBackContinue() {
        char letter;
        System.out.println("\nMillion dollar question...\nWhich of the following " +
                "gases makes up the largest portion of the atmosphere? " +
                "\na) Oxygen" +
                "\nb) Hydrogen " +
                "\nc) Carbon dioxide " +
                "\nd) Nitrogen");
        do {
            letter = scanner.nextLine().toUpperCase().charAt(0);
            scoreResult();
            if (letter == 'A') {
                score = score - 10;
                System.out.println("\nWell if Nitrogen wasn't on the board, you " +
                        "would be almost correct. Oxygen is the 2nd largest portion of the " +
                        "atmosphere.");
                System.out.println(scoreResult().get(score));
                playAgain();
            } else if (letter == 'B') {
                score = score - 30;
                System.out.println("\nAlthough you got Oxygen correct, physical retaliation against any patient is NOT acceptable!");
                System.out.println(scoreResult().get(score));
                playAgain();
            } else if (letter == 'C') {
                score = score - 30;
                System.out.println("\nAlthough you got Oxygen correct, physical retaliation against any patient is NOT acceptable!");
                System.out.println(scoreResult().get(score));
                playAgain();
            } else if (letter == 'D') {
                score = score + 30;
                System.out.println("\nNitrogen indeed is the largest portion of the atmosphere, although most people think it is Oxygen.");
                System.out.println(scoreResult().get(score));
                playAgain();
            } else {
                System.out.println("Sorry, must type A, B, C or D");
            }
        } while (true);
    }

    public void supervisor() {
        String userInput;
        System.out.println("\nYour supervisor arrives on seen and asks you why you gave " +
                "him the Heimlich maneuver. \nDo you: " +
                "\na) Tell a 'Lie'  " +
                "\nb) Tell the 'Truth' ");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("LIE")) {
                System.out.println("\nMy mechanical assumption tells me that you might have a " +
                        "high likelihood of seriously\ninjuring a patient but if you would like to" +
                        "increase your chances, type 'Continue' or type 'End' to get your Analysis.");
                score = score - 40;
                userInput = scanner.nextLine().toUpperCase();
                if (userInput.equals("CONTINUE")) {
                    supervisorLieContinue();
                } else if (userInput.equals("END")) {
                    System.out.println("\n" + scoreResult().get(score));
                    playAgain();
                } else {
                    System.out.println("Please type 'Continue' ");
                }
            } else if (userInput.equals("TRUTH")) {
                truth();
            } else {
                System.out.println("Sorry, must type 'Lie' or 'Truth'!");
            }
        } while (true);
    }

    public void truth() {
        String userInput;
        System.out.println("\nI applaud your honesty, but now your supervisor looks " +
                "confused and upset. \nHe is wondering why you gave the heimlich " +
                "maneuver to begin with, but he appreciates your honesty. \nHe then " +
                "asked if you would \nPrefer to: " +
                "\na) Go 'Home' for the day " +
                "\nb) Continue your 'Shift' ");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("HOME")) {
                home();
            } else if (userInput.equals("SHIFT")) {
                shift();
            } else {
                System.out.println("Sorry, must type 'Home' or 'Shift'!");
            }
        } while (true);
    }

    public void home() {
        scoreResult();
        System.out.println("\nWell I must say, you started off a bit cold, but overall you " +
                "were able to find the most optimal solution for your problem.");
        System.out.println(scoreResult().get(score));
        playAgain();
    }

    public void shift() {
        String userInput;
        System.out.println("\nOkay, you are definitely brave, I applaud that! BUT I must find out " +
                "if you are still cognitively \ncapable of continuing you job. To test it out, type " +
                "'Continue' or type 'End' to get your Analysis.");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("CONTINUE")) {
                shiftContinue();
            } else if (userInput.equals("END")) {
                System.out.println("\n" + scoreResult().get(score));
                playAgain();
            } else {
                System.out.println("Please type 'Continue' ");
            }
        } while (true);
    }

    public void shiftContinue() {
        String userInput;
        System.out.println("\nThe ________ artery is the major artery in the neck, and is the " +
                "main supplier of blood to the head. " +
                "\na) Femoral " +
                "\nb) Brachial " +
                "\nc) Carotid " +
                "\nd) Radial ");
        do {
            userInput = scanner.nextLine().toUpperCase();
            scoreResult();
            switch (userInput) {
                case "A":
                    score = score - 30;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "B":
                    score = score - 30;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "C":
                    score = score + 30;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "D":
                    score = score - 30;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                default:
                    System.out.println("Sorry, must type A, B, C or D");
                    break;
            }
        } while (true);
    }

    public void dealAlone() {
        String userInput;
        System.out.println("\nIts on and poppin now! You have made wrong choices until now but everyone deserves a try. " +
                "For one more shot, type 'Continue' or type 'End' to get your Analysis.");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("CONTINUE")) {
                dealAloneContinue();
            } else if (userInput.equals("END")) {
                System.out.println("\n" + scoreResult().get(score));
                playAgain();
            } else {
                System.out.println("Please type 'Continue' ");
            }
        } while (true);
    }

    public void dealAloneContinue() {
        String userInput;
        System.out.println("\nMillion dollar question. The term bilateral refers to: " +
                "\na) Both lungs." +
                "\nb) One side." +
                "\nc) Frontal skull." +
                "\nd) Both sides.");
        do {
            userInput = scanner.nextLine().toUpperCase();
            scoreResult();
            switch (userInput) {
                case "A":
                    score = score - 20;
                    System.out.println("\nYou are right but WRONG, bilateral simply means both sides of the body");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "B":
                    score = score - 30;
                    System.out.println("\nWrong! Bilateral refers to both sides of the body");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "C":
                    score = score - 30;
                    System.out.println("\nWrong! Bilateral refers to both sides of the body");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "D":
                    score = score + 30;
                    System.out.println("\nCorrect! Thought I could trick you.");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                default:
                    System.out.println("Sorry, must type A, B, C or D");
                    break;
            }
        } while (true);
    }

    public void supervisorLieContinue() {
        String userInput;
        System.out.println("\nOk lets test your vocabulary knowledge. \nA patient who is " +
                "supine is lying:\na) Face up" +
                "\nb) Face down" +
                "\nc) On the left side" +
                "\nd) On the right side");
        do {
            userInput = scanner.nextLine().toUpperCase();
            scoreResult();
            switch (userInput) {
                case "A":
                    score = score + 30;
                    System.out.println("\nYou are absolutely correct. You made a few wrong decisions " +
                            "along but your knowledge on this key terms might help you along your " +
                            "journey.");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "B":
                    score = score - 30;
                    System.out.println("\nWell you flunked the entire way, better luck next time!");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "C":
                    score = score - 30;
                    System.out.println("\nWell you flunked the entire way, better luck next time!");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "D":
                    score = score - 30;
                    System.out.println("\nWell you flunked the entire way, better luck next time!");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                default:
                    System.out.println("Sorry, must type A, B, C or D");
                    break;
            }
        } while (true);
    }

    public void callCops() {
        String userInput;
        System.out.println("\nCops arrives and sees a small tussle. \nShould they: " +
                "\na) 'Stunt' him" +
                "\nb) 'Cuff' him?");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("STUNT")) {
                score = score - 40;
                stunt();
            } else if (userInput.equals("CUFF")) {
                cuff();
            } else {
                System.out.println("Sorry, must type either 'Stunt' or 'Cuff' ");
            }
        } while (true);
    }

    public void stunt() {
        String userInput;
        System.out.println("\nI am sorry but my professional analysis suggests that " +
                "you should possibly not become an EMT nor a Cop \nnor anything of " +
                "authority. " + "\nBut if you " + "would like some bonus points, " +
                "type 'Continue' or type 'End' to get your Analysis.");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("CONTINUE")) {
                ifStuntContinue();
            } else if (userInput.equals("END")) {
                System.out.println("\n" + scoreResult().get(score));
                playAgain();
            } else {
                System.out.println("Please type 'Continue' ");
            }
        } while (true);
    }

    public void ifStuntContinue() {
        String userInput;
        System.out.println("\nEpinephrine administered for severe allergic reaction may cause?" +
                "\na) Vomiting" +
                "\nb) Nausea" +
                "\nc) Chest pain" +
                "\nd) All of the above");
        do {
            userInput = scanner.nextLine().toUpperCase();
            scoreResult();
            switch (userInput) {
                case "A":
                    score = score - 30;
                    System.out.println("\nWell technically you are 25% correct but Nausea and " +
                            "Chest pain are also correct.");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "B":
                    score = score - 30;
                    System.out.println("\nWell technically you are 25% correct but Vomiting " +
                            "and Chest pain are also correct.");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "C":
                    score = score - 30;
                    System.out.println("\nWell technically you are 25% correct but Vomiting " +
                            "and Nausea are also correct.");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "D":
                    score = score + 30;
                    System.out.println("\nSeems like you might have a chance after all. Hey " +
                            "guess being any EMT might not be so far fetched");
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                default:
                    System.out.println("Sorry, must type A, B, C or D");
                    break;
            }
        } while (true);
    }

    public void cuff() {
        String userInput;
        System.out.println("\nYour patient was handcuffed and safely transported to the hospital, " +
                "while driving the ambulance using \n'lights and sirens', the light ahead suddenly " +
                "turns red, \nDo you: " +
                "\na) 'Stop' first before continuing  " +
                "\nb) Drive 'Faster' to cross the light as fast as possible");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("STOP")) {
                stop();
            } else if (userInput.equals("FASTER")) {
                score = score - 40;
                ifFaster();
            } else {
                System.out.println("Sorry, must type 'Stop' or 'Faster' ");
            }
        } while (true);
    }

    public void stop() {
        String userInput;
        System.out.println("\nYou are doing amazing, but for extra Bonus, type 'Continue' " +
                "or type 'End' to get your Analysis.");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("CONTINUE")) {
                ifStopContinue();
            } else if (userInput.equals("END")) {
                System.out.println("\n" + scoreResult().get(score));
                playAgain();
            } else {
                System.out.println("Please type 'Continue' ");
            }
        } while (true);
    }

    public void ifStopContinue() {
        String userInput;
        System.out.println("The average adult has how many gallons of blood?" +
                "\na) 4.5 " +
                "\nb) 1.5 " +
                "\nc) 3.5 " +
                "\nd) 2.5 ");
        do {
            userInput = scanner.nextLine().toUpperCase();
            scoreResult();
            switch (userInput) {
                case "A":
                    System.out.println("\nUnfortunately you are wrong, this would be enough blood for about 3 adults");
                    score = score - 20;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "B":
                    System.out.println("\nCorrect! You are stunningly smart!");
                    score = score + 20;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "C":
                    System.out.println("\nSorry but 3.5 gallons of blood can be found in about 2 adults and one child");
                    score = score - 20;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "D":
                    System.out.println("\nI understand why you might have chosen this answer but wrong!");
                    score = score - 20;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                default:
                    System.out.println("Sorry, must type A, B, C or D");
                    break;
            }
        } while (true);
    }

    public void ifFaster() {
        String userInput;
        System.out.println("\nI am not sure how much you've learned about driving an ambulance, " +
                "but that was the wrong decision. For a bonus question, please type 'Continue' " +
                "or type 'End' to get your Analysis.");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("CONTINUE")) {
                ifFasterContinue();
            } else if (userInput.equals("END")) {
                System.out.println("\n" + scoreResult().get(score));
                playAgain();
            } else {
                System.out.println("Please type Continue");
            }
        } while (true);
    }

    public void ifFasterContinue() {
        String userInput;
        scoreResult();
        System.out.println("\nOk, Bonus question:" +
                "\nThe _________ artery carries oxygen-poor blood from the heart to the lungs." +
                "\na) Brachial" +
                "\nb) Carotid" +
                "\nc) Pulmonary" +
                "\nd) Radial");
        userInput = scanner.nextLine().toUpperCase();
        while (!userInput.equals("A") || !userInput.equals("B") || !userInput.equals("C") || !userInput.equals("D")) {
            switch (userInput) {
                case "A":
                    System.out.println("\n... ");
                    score = score - 30;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "B":
                    System.out.println("\n... ");
                    score = score - 30;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "C":
                    System.out.println("\nCorrect!");
                    score = score + 30;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                case "D":
                    System.out.println("\n... ");
                    score = score - 30;
                    System.out.println(scoreResult().get(score));
                    playAgain();
                    break;
                default:
                    System.out.println("Sorry, must type A, B, C or D");
            }
        }
    }

    public HashMap<Integer, String> scoreResult() {
        HashMap<Integer, String> hashMap1 = new HashMap<>();
        hashMap1.put(20, "Analysis: You would probably make one of the worst EMT's ever!");
        hashMap1.put(30, "Analysis: According to all your answers, I would suggest that you please find a different career path.");
        hashMap1.put(50, "Analysis: Try your luck, but don't say I sent you!");
        hashMap1.put(60, "Analysis: You might have a shot after-all! Clearly I am just a machine, what do I really know!");
        hashMap1.put(80, "Analysis: You definitely have a shot at it!");
        hashMap1.put(90, "Analysis: You have a high chance of succeeding in this field");
        hashMap1.put(100, "Analysis: Well I must say you would make an excellent EMT.");
        hashMap1.put(120, "Analysis: You scored above average. Please take on this amazing journey as an EMT");
        return hashMap1;
    }

    public void playAgain() {
        String userInput;
        System.out.println("\nWould you like to play Again? 'Yes' or 'No' ");
        do {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("YES")) {
                score = 100;
                startQuestion();
            } else if (userInput.equals("NO")) {
                System.out.println("Your loss!");
                break;
            } else {
                System.out.println("Please type 'Yes' or 'No' ");
            }
        } while (true);
    }
}

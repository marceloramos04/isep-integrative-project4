package utils;

import menu.MenuItem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    private static Scanner scanner = new Scanner(System.in);

    public static void resetScanner() {
        scanner = new Scanner(System.in);
    }
    /**
     * Read line from console string.
     *
     * @param prompt the prompt
     * @return the string
     */
    public static String readLineFromConsole(String prompt) {

        try {
            System.out.println(prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            String line = in.readLine();
            System.out.println();
            return line;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Read integer from console int.
     *
     * @param prompt the prompt
     * @return the int
     */
    public static int readIntegerFromConsole(String prompt) {

        int value = -1;
        boolean valid = false;

        do {
            try {
                String input = readLineFromConsole(prompt);

                assert input != null;
                value = Integer.parseInt(input);
                valid = true;

            } catch (NumberFormatException ex) {
                System.out.println("ERROR: INVALID INTEGER NUMBER\n");
            }

        } while (!valid);

        return value;
    }

    public static int readIntegerFromConsole1(String prompt) {
        int value = -1;
        boolean valid = false;

        do {
            try {
                System.out.println(prompt);
                String line = scanner.nextLine(); // read the input as a string
                value = Integer.parseInt(line); // convert the string to an integer
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: INVALID INTEGER NUMBER");
            }
        } while (!valid);

        return value;
    }

    public static String readLineFromConsole1(String prompt) {
        System.out.println(prompt);
        String line = scanner.nextLine(); // read the input as a string
        return line;
    }

    /**
     * Read positive integer from console int.
     *
     * @param prompt the prompt
     * @return the int
     */
    public static int readPositiveIntegerFromConsole(String prompt) {

        int value = -1;
        boolean valid = false;

        do {
            try {
                String input = readLineFromConsole(prompt);

                assert input != null;
                value = Integer.parseInt(input);

                if (value < 0) {
                    throw new InvalidParameterException();
                }

                valid = true;

            } catch (InvalidParameterException | NumberFormatException ex) {
                System.err.println("ERROR: INVALID POSITIVE INTEGER\n");

            }
        } while (!valid);

        return value;
    }

    /**
     * Read double from console double.
     *
     * @param prompt the prompt
     * @return the double
     */
    public static double readDoubleFromConsole(String prompt) {
        do {
            try {
                String input = readLineFromConsole(prompt);

                assert input != null;
                return Double.parseDouble(input);

            } catch (NumberFormatException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (true);
    }

    /**
     * Read long from console long.
     *
     * @param prompt the prompt
     * @return the long
     */
    public static long readLongFromConsole(String prompt) {

        do {
            try {
                String input = readLineFromConsole(prompt);

                assert input != null;
                return Long.parseLong(input);

            } catch (NumberFormatException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    /**
     * Read date from console date.
     *
     * @param prompt the prompt
     * @return the date
     */
    public static Date readDateFromConsole(String prompt) {
        do {
            try {
                String strDate = readLineFromConsole(prompt + " (DD-MM-YYYY)");

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                return df.parse(strDate);

            } catch (ParseException ex) {
                System.err.println("ERROR: DATE FORMAT INVALID");
            }

        } while (true);
    }

    /**
     * Read date from console date.
     *
     * @param prompt the prompt
     * @return the date
     */
    public static LocalDate readLocalDateFromConsole(String prompt) throws ParseException {
        do {
            String strDate = readLineFromConsole(prompt + " (DD-MM-YYYY)");
            return LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            //SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            //return df.parse(strDate);

        } while (true);
    }

    /**
     * Confirm boolean.
     *
     * @param message the message
     * @return the boolean
     */
    public static boolean confirm(String message) {

        String input;

        do {
            input = Utils.readLineFromConsole("\n" + message);

        } while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n") && !input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
    }

    /**
     * Show and select one object.
     *
     * @param list   the list
     * @param header the header
     * @return the object
     */
    public static Object showAndSelectOne(List list, String header) {
        showList(list, header);
        return selectsObject(list);
    }

    /**
     * Show and select index int.
     *
     * @param list   the list
     * @param header the header
     * @return the int
     */
    public static int showAndSelectIndex(List list, String header) {
        showList(list, header);
        return selectsIndex(list);
    }

    /**
     * Show list.
     *
     * @param list   the list
     * @param header the header
     */
    public static void showList(List list, String header) {
        System.out.println(header);

        int index = 0;
        for (Object o : list) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println();
        System.out.println("0 - Cancel");
    }

    /**
     * Selects object object.
     *
     * @param list the list
     * @return the object
     */
    public static Object selectsObject(List list) {

        String input;
        int value;

        do {
            input = Utils.readLineFromConsole("INSERT OPTION: ");

            value = Integer.valueOf(input);

        } while (value < 0 || value > list.size());

        if (value == 0) {
            return null;
        } else {
            return list.get(value - 1);
        }
    }

    /**
     * Selects index int.
     *
     * @param list the list
     * @return the int
     */
    public static int selectsIndex(List list) {

        String input;
        Integer value;

        do {
            input = Utils.readLineFromConsole("INSERT OPTION: ");

            try {
                value = Integer.valueOf(input);

            } catch (NumberFormatException ex) {
                value = -1;
            }

        } while (value < 0 || value > list.size());

        return value - 1;
    }

    /**
     * Read float from console double.
     *
     * @param prompt the prompt
     * @return the float
     */
    public static float readFloatFromConsole(String prompt) {

        do {
            try {
                String input = readLineFromConsole(prompt);

                assert input != null;
                return Float.parseFloat(input);

            } catch (NumberFormatException ex) {

                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (true);
    }

    /**
     * Enter to continue.
     */
    public static void enterToContinue() {
        readLineFromConsole("Press [Enter] to continue...");
    }

    /**
     * Show and select one generic e.
     *
     * @param <E>    the type parameter
     * @param list   the list
     * @param header the header
     * @return the e
     */
    public static <E> E showAndSelectOneGeneric(List<E> list, String header) {
        showListGeneric(list, header);
        return selectObjectGeneric(list);
    }

    /**
     * Show list generic.
     *
     * @param <E>    the type parameter
     * @param list   the list
     * @param header the header
     */
    public static <E> void showListGeneric(List<E> list, String header) {
        System.out.println(header);

        int index = 0;
        for (E o : list) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println();
        System.out.println("0 - Cancel");
    }

    /**
     * Select object generic e.
     *
     * @param <E>  the type parameter
     * @param list the list
     * @return the e
     */
    public static <E> E selectObjectGeneric(List<E> list) {
        String input;
        int value;

        do {
            input = Utils.readLineFromConsole("INSERT OPTION: ");
            assert input != null;
            value = Integer.parseInt(input);

        } while (value < 0 || value > list.size());

        if (value == 0) {
            return null;
        } else {
            return list.get(value - 1);
        }
    }

    /**
     * Run menu.
     *
     * @param options the options
     * @param header  the header
     */
    public static void runMenu(List<MenuItem> options, String header) {
        String space = "----------------";
        int option = 0;

        do {
            option = Utils.showAndSelectIndex(options, String.format("%s  %s  %s", space, header, space));

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }

    /**
     * Gets boolean answer.
     *
     * @param header the header
     * @return the boolean answer
     */
    public static boolean getBooleanAnswer(String header) {
        ArrayList<String> yes_or_no = new ArrayList<>();
        yes_or_no.add("Yes");
        yes_or_no.add("No");

        int in = showAndSelectIndex(yes_or_no, header);
        return in == 0;
    }

    /**
     * Gets local date from console.
     *
     * @param header     the header
     * @param dateFormat the date format
     * @return the local date from console
     */
    public static LocalDate getLocalDateFromConsole(String header, String dateFormat) {
        boolean validInput = false;
        LocalDate date = null;

        do {
            String input = readLineFromConsole(header);

            try {
                assert input != null;
                date = LocalDate.parse(input, DateTimeFormatter.ofPattern(dateFormat));
                validInput = true;

            } catch (DateTimeParseException e) {
                System.out.println("Data inválida\n");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (!validInput);

        return date;
    }

    public static int readYearFromConsole(String prompt) {

        boolean valid = false;
        int year = -1;

        do {
            try {
                year = Integer.parseInt(readLineFromConsole(prompt));

                if (year < 0 || year > LocalDate.now().getYear()) {
                    throw new NumberFormatException();
                }
                valid = true;

            } catch (NumberFormatException | NullPointerException e) {
                System.err.println("ERRO: Ano inválido\n");
            }

        } while (!valid);
        return year;
    }

    public static long readPositiveLongFromConsole(String prompt) {

        long value = -1;
        boolean valid = false;

        do {
            try {
                String input = readLineFromConsole(prompt);

                assert input != null;
                value = Long.parseLong(input);

                if (value < 0) {
                    throw new InvalidParameterException();
                }

                valid = true;

            } catch (InvalidParameterException | NumberFormatException ex) {
                System.err.println("ERROR: INVALID POSITIVE LONG NUMBER\n");

            }
        } while (!valid);

        return value;
    }

    public static LocalTime readLocalTimeFromConsole(String prompt) {
        LocalTime time = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = readLineFromConsole(prompt + " (HH:MM)");
                time = LocalTime.parse(input, DateTimeFormatter.ofPattern("HH:mm"));
                validInput = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please enter the time in the format: HH:MM");
            }
        }

        return time;
    }

    public static String formatLocalDateTime(LocalDateTime ldt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return ldt.format(formatter);
    }

    public static String formatLocalDate(LocalDate ld) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return ld.format(formatter);
    }

}

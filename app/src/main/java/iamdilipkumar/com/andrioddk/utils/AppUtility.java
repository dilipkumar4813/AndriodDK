package iamdilipkumar.com.andrioddk.utils;

/**
 * Utilities class for the entire application
 *
 * @author dilipkumar4813
 * @version 1.0
 * @since 28/10/17.
 */

public class AppUtility {

    /**
     * Method to check if a string is empty or null and return boolean
     *
     * @param data - String to be tested
     * @return - boolean
     */
    public static boolean isNotNullOrEmpty(String data) {
        if (data != null) {
            if (!data.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}

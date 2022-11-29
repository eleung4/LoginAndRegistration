package com.example.loginandregistration

    // object keyword makes it so all the functions are
    // static functions
object RegistrationUtil {
    // use this in the test class for the is username taken test
    // make another similar list for some taken emails
    var existingUsers = listOf("cosmicF", "cosmicY", "bob", "alice")
    //    you can use listOf<type>() instead of making the list & adding individually
    //    List<String> blah = new ArrayList<String>();
    //    blah.add("hi")
    //    blah.add("hello")
    //

    // isn't empty
    // already taken
    // minimum number of characters is 3
    fun validateUsername(username: String) : Boolean {
        if(username!=null && username.length>=3) {
            return true
        }
        return false
    }

    // make sure meets security requirements (deprecated ones that are still used everywhere)
    // min length 8 chars
    // at least one digit
    // at least one capital letter
    // both passwords match
    // not empty
    fun validatePassword(password : String, confirmPassword: String) : Boolean {
        if(password!=null && confirmPassword!=null && password.equals(confirmPassword)) {
            if(password.length>=8 && password.contains("[A-Z]".toRegex())
                && password.contains("[0-9]".toRegex())){
                return true
            }
            return false
        }
        return false
    }

    // isn't empty
    fun validateName(name: String) : Boolean {
        if(name!=null) {
            return true
        }
        return false
    }

    // isn't empty
    // make sure the email isn't used
    // make sure it's in the proper email format user@domain.tld
    fun validateEmail(email: String) : Boolean {
        if(email!=null) {
            var seg = email.indexOf("@")
            var maybe = email.substring(0, seg)
            for(name in existingUsers) {
                if(maybe != name) {
                    if(email.substring(email.indexOf("@"))=="@domain.tld") {
                        return true
                    }

                }
            }
        }
        return false
    }
}



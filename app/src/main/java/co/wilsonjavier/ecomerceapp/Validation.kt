package co.wilsonjavier.ecomerceapp

import org.intellij.lang.annotations.Pattern

fun validateEmail(email: String) : Pair<Boolean,String>{
    return when{
        email.isEmpty() ->Pair(false,"El correp es requerido.")
        !Pattern.EMAIL_ADDRESS.matcher(email.matches()->Pair(false, "El correo es invalido"))
        email.endsWith("@test.com")-> Pair(false, "Este email no es corporativo")
        else -> {
            Pair(true,"")
        }
    }

}

fun validatePassword(password:String) : Pair<Boolean,String>{
    return when{
        password.isEmpty() -> Pair(false,"la contrasena es requerida")
        password.length < 8 ->Pair(false, "la contrasena debe tener 8 caracteres")
        !password.any{ it.isDigit() } -> Pair(false, "la contrasena debe tener almenos un numero")
        else -> Pair(true,"")
    }
}

fun validateName (name: String): Pair<Boolean, String>{
    return when{
        name.isEmpty() -> Pair(false, "El nombre es requerido")
        name.length < 3 ->  Pair(false,"El nombre debe tener al menos 3 caracteres")
        else -> Pair(true,"")
    }
}

fun validateConfirmPassword(password: String, confirmPassword: String): Pair<Boolean, String>{
    return when{
        confirmPassword.isEmpty() ->Pair(false,"la contrasena es requerida")
        confirmPassword != password -> Pair(false, "las contrasena no coinciden")
        else -> Pair(true,"")
    }
}
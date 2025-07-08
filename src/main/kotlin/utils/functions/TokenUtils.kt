package ar.edu.unsam.phm.utils.functions

import ar.edu.unsam.phm.utils.FRONTEND_URL

fun createConfirmationOrRecoveryLink(token: String) = "$FRONTEND_URL/emailConfirmation?token=$token"
package com.mobven.mmbkittester.statemachine

object StateMachineJson {

    val jsonData = """
        {
            "forms": [
                {
                    "title": "Personal Info",
                    "objectId": "88o6S49W4k",
                    "fields": [
                        {
                            "id": "nameSurname",
                            "label": "Name Surname",
                            "placeholder": "Name Surname",
                            "type": "text",
                            "inputType": "text",
                            "rules": {
                                "regex": "([a-zA-Z',.-]+( [a-zA-Z',.-]+)*){2,30}",
                                "message": "Name and Surname is not valid!",
                                "isRequired": true
                            }
                        },
                        {
                            "id": "tckn",
                            "label": "Identity Number",
                            "placeholder": "Identity Number",
                            "type": "text",
                            "inputType": "password",
                            "rules": {
                                "regex": "[a-zA-Z0-9',.-]{5,20}",
                                "message": "Password must contain 5 to 20 characters.",
                                "isRequired": true
                            }
                        },
                        {
                            "id": "city",
                            "label": "Choose City",
                            "placeholder": "Choose City",
                            "type": "select",
                            "options": [
                                {
                                    "id": "34",
                                    "name": "Istanbul"
                                },
                                {
                                    "id": "10",
                                    "name": "Baku"
                                }
                            ],
                            "rules": {
                                "message": "Please choose your city.",
                                "regex": ".+",
                                "isRequired": true
                            }
                        },
                        {
                            "id": "gender",
                            "label": "Gender",
                            "placeholder": "Gender",
                            "type": "radio",
                            "options": [
                                {
                                    "id": "0",
                                    "name": "Woman"
                                },
                                {
                                    "id": "1",
                                    "name": "Man"
                                }
                            ],
                            "rules": {
                                "message": "Please select your gender.",
                                "isRequired": true
                            }
                        },
                        {
                            "id": "t&c",
                            "label": "Terms and conditions",
                            "placeholder": "",
                            "type": "checkbox",
                            "status": false,
                            "rules": {
                                "message": "Please accept terms and conditions.",
                                "isRequired": true
                            }
                        },
                        {
                            "id": "privacy",
                            "label": "Privacy Policy",
                            "placeholder": "",
                            "type": "checkbox",
                            "status": false,
                            "rules": {
                                "message": "Please accept privacy policy.",
                                "isRequired": true
                            }
                        },
                        {
                            "id": "submit",
                            "type": "action",
                            "value": "Next",
                            "actionType": "next"
                        }
                    ]
                },
                {
                    "title": "Account Info",
                    "objectId": "aG4OCBnq3A",
                    "fields": [
                        {
                            "id": "nameSurname",
                            "label": "Amount",
                            "placeholder": "Amount",
                            "type": "text",
                            "inputType": "number",
                            "rules": {
                                "regex": "([a-zA-Z',.-]+( [a-zA-Z',.-]+)*){2,30}",
                                "message": "Name and Surname is not valid!",
                                "isRequired": true
                            }
                        },
                        {
                            "id": "tckn",
                            "label": "Identity Number",
                            "placeholder": "Identity Number",
                            "type": "text",
                            "inputType": "password",
                            "rules": {
                                "regex": "[a-zA-Z0-9',.-]{5,20}",
                                "message": "Password must contain 5 to 20 characters.",
                                "isRequired": true
                            }
                        },
                        {
                            "id": "city",
                            "label": "Choose City",
                            "placeholder": "Choose City",
                            "type": "select",
                            "options": [
                                {
                                    "id": "34",
                                    "name": "Istanbul"
                                },
                                {
                                    "id": "10",
                                    "name": "Baku"
                                }
                            ],
                            "rules": {
                                "message": "Please choose your city.",
                                "isRequired": true
                            }
                        },
                        {
                            "id": "gender",
                            "label": "Gender",
                            "placeholder": "Gender",
                            "type": "radio",
                            "options": [
                                {
                                    "id": "0",
                                    "name": "Woman"
                                },
                                {
                                    "id": "1",
                                    "name": "Man"
                                }
                            ],
                            "rules": {
                                "message": "Please select your gender.",
                                "isRequired": true
                            }
                        },
                        {
                            "id": "submit",
                            "type": "action",
                            "value": "Submit",
                            "actionType": "next"
                        }
                    ]
                }
            ]
            }
    """

}
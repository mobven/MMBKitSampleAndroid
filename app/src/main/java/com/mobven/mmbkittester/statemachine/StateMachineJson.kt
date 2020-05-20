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
                            "value": "",
                            "rules": {
                                "regex": "([a-zA-Z',.-]+( [a-zA-Z',.-]+)*){2,30}",
                                "message": "Name and Surname is not valid!",
                                "isRequired": false
                            }
                        },
                        {
                            "id": "tckn",
                            "label": "Identity Number",
                            "placeholder": "Identity Number",
                            "type": "text",
                            "inputType": "password",
                            "value": "",
                            "rules": {
                                "regex": "[a-zA-Z0-9',.-]{5,20}",
                                "message": "Password must contain 5 to 20 characters.",
                                "isRequired": false
                            }
                        },
                        {
                            "id": "textarea",
                            "label": "Personal Info",
                            "placeholder": "Personal Info",
                            "type": "textarea",
                            "inputType": "",
                            "value": "",
                            "rules": {
                                "isRequired": false
                            }
                        },
                        {
                            "id": "city",
                            "label": "Choose City",
                            "placeholder": "Choose City",
                            "type": "select",
                            "value": "",
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
                            "value": "",
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
                            "label": "Terms and conditionserms",
                            "placeholder": "",
                            "type": "checkbox",
                            "value": "",
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
                            "value": "",
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
                            "value": "",
                            "rules": {
                                "regex": "([a-zA-Z',.-]+( [a-zA-Z',.-]+)*){2,30}",
                                "message": "Name and Surname is not valid!",
                                "isRequired": false
                            }
                        },
                        {
                            "id": "tckn",
                            "label": "Identity Number",
                            "placeholder": "Identity Number",
                            "type": "text",
                            "inputType": "password",
                            "value": "",
                            "rules": {
                                "regex": "[a-zA-Z0-9',.-]{5,20}",
                                "message": "Password must contain 5 to 20 characters.",
                                "isRequired": false
                            }
                        },
                        {
                            "id": "textarea",
                            "label": "Personal Info",
                            "placeholder": "Personal Info",
                            "type": "textarea",
                            "inputType": "",
                            "value": "",
                            "rules": {
                                "isRequired": false
                            }
                        },
                        {
                            "id": "city",
                            "label": "Choose City",
                            "placeholder": "Choose City",
                            "type": "select",
                            "value": "",
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
                            "value": "",
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
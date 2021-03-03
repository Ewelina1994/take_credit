# take_credit
Application for submitting new credits with applicants and products and displaying credits


API:
*download of all credits with lists of products and customers: path: /credit method get

*adding a new credit path: /credit method post body:
example:
{
"creditName": "8/2021",
"customers": [
{
"firstname": "Ola",
"surname": "Ulanowska",
"pesel": 12100
},
{
"firstname": "Miłosz",
"surname": "Ulanowski",
"pesel": 12100
}
],
"products": [
{
"productName": "Kredyt got",
"value": 5000
}
]
}

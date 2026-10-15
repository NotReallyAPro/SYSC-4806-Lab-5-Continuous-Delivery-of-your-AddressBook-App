SYSC4806 Lab 5 example application

Domain: https://exampleapp-gqaedhdydeefbte6.northcentralus-01.azurewebsites.net

Run curl commands in powershell.

1. Create an AddressBook: 
   curl.exe -X POST "https://exampleapp-gqaedhdydeefbte6.northcentralus-01.azurewebsites.net/addressBooks" -H "Content-Type: application/json" -d "{}"

2. Create a BuddyInfo:
   Add or modify BuddyInfo object in buddy.json and run the following command from the
   directory containing buddy.json:
   curl.exe -X POST "https://exampleapp-gqaedhdydeefbte6.northcentralus-01.azurewebsites.net/buddyInfoes" -H "Content-Type: application/json" --data-binary "@buddy.json"

3. Add a BuddyInfo to an AddressBook:
   Replace {addressBookId} and {buddyInfoId} with their respective IDs. Do not include the curly brackets.
   curl.exe -X POST "/addressBooks/{addressBookId}/buddies" -H "Content-Type: text/uri-list" --data-raw "https://exampleapp-gqaedhdydeefbte6.northcentralus-01.azurewebsites.net/buddyInfoes/{buddyInfoId}"

4. View buddies in an AddressBook using REST:
   curl.exe "https://exampleapp-gqaedhdydeefbte6.northcentralus-01.azurewebsites.net/addressBooks/{addressBookId}/buddies"

5. View buddies in an AddressBook using Thymeleaf:
   https://exampleapp-gqaedhdydeefbte6.northcentralus-01.azurewebsites.net/addressbooks?id={addressBookId}

Morgan Huang 101232958

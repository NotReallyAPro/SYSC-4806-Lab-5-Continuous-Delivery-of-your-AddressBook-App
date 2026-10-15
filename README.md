SYSC4806 Lab 5 example application

Domain: https://exampleapp-gqaedhdydeefbte6.northcentralus-01.azurewebsites.net

Run curl commands in powershell. Replace {Domain} with the full domain URL. Do not include the curly braces.

1. Create an AddressBook 
   curl.exe -X POST "{Domain}/addressBooks" -H "Content-Type: application/json" -d "{}"

2. Create a BuddyInfo
   Add or modify BuddyInfo object in buddy.json and run the following command from the
   directory containing buddy.json:
   curl.exe -X POST "{Domain}/buddyInfoes" -H "Content-Type: application/json" --data-binary "@buddy.json"

3. Add a BuddyInfo to an AddressBook
   Replace {addressBookId} and {buddyInfoId} with their respective IDs. Do not include the curly brackets.
   curl.exe -X POST "{Domain}/addressBooks/{addressBookId}/buddies" -H "Content-Type: text/uri-list" --data-raw "{Domain}/buddyInfoes/{buddyInfoId}"

4. View buddies in an AddressBook using REST
   curl.exe "{Domain}/addressBooks/{addressBookId}/buddies"

5. View buddies in an AddressBook using Thymeleaf
   {Domain}/addressbooks?id={addressBookId}

Morgan Huang 101232958

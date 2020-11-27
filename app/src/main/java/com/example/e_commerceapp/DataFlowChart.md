# How the data will flow 

1. User opens up
2. App does a request to server to retrieve (whatever) "10" random items.
   Each item will have a name and pricing only. 
3. Customer clicks on item 
4. "Item" Activity pulls more data from the server 
5. Customer clicks on "Add to cart"
6. "Item" activity saves the item values to "SharedPreferences" 
                (String "key", String "variable")
                (String "Item Name", String "New Balance shoe")
                (String "Item Cost", Double "Cost")
                etc etc etc 
                
7. 
                
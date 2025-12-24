## Mystery Mansion Adventure

Players explore a mansion with multiple rooms and NPCs. Rooms (Room class) can store items (Item class) and characters (NPC class) in ArrayLists. The story: solve a mystery by visiting rooms, talking to NPCs, and collecting clues. The game uses commands like “GO kitchen,” “TAKE key,” “TALK butler.” Each action triggers methods that update state and story progress. Multiple endings are possible based on clues found.

Required implementation & minimum features:

• Use at least 4 classes: Room, Item, NPC, Game (or World), plus Main. 

• Use ArrayList<Item> in rooms and in the player’s inventory; optional ArrayList<NPC> per room.

• Define a fixed set of rooms (at least 6–8) and connections between them. 

• Implement a command system:
      o Basic commands: GO (move), LOOK, TAKE, DROP, TALK, INVENTORY. 
• Implement clue collection: 
      o Certain items or NPC dialogues count as clues.
      
• Track player progress: 
      o Based on collected clues and visited rooms. 
      
• Implement at least one winning ending (correctly accusing the culprit) and one losing ending (accusing wrong person or running out of turns). 

## File and Class Function
- Main
  Buat main program berjalan kayak main menu, dll
- Item
  Class untuk item dan kegunaan itemnya
- NPC
  Class untuk NPC yang ada di dalam game
- Room
  Class untuk room yang ada di mansion

## Comment

Kalo butuh class baru tambah ae gaapa tapi lewat pull/issue request dulu atau chat di grup WA biar tak tambahin.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies




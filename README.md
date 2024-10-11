* UML klassdiagram i .idea-folder.
* Utgick från gruppens (grupp 4) planering, men har gjort väsentliga förändringar i vad och hur saker struktureras i respektive klasser.
* Diagram innehålller även klasser och interface som i ett större projekt inte hör specifikt till Inventory, och borde egentligen hållas separat,
* men valde att inkludera här då det ingår i hur jag testade att implementera vissa delar av Inventory i enlighet med uppgiften - och det var kul att prova skissa även denna bit,
* samt att mitt projekts ringa omfång gjorde det omotiverat att skapa ett separat diagram för denna del.
* Jag skapade nog inte fler klasser än vad uppgiften uttryckligen krävde. Jag tyckte det var svårt att inom omfånget komma på bra anledningar till att skapa t ex fler subklasser för
* Weapon eller Armor, utan att också planera för själva speldesignen. Att göra det ena utan det andra blev omotiverat godtyckligt.
* Hanterar t ex physical/magic med Enum i detta stadie. Även olika typer av consumables hanteras med Enum.
* Fick tidigt en idé om att hantera equip med Enum och HashMap, vilket blev en av de delarna jag spenderade mest tid på att implementera i kod. Här tyckte jag också att det var
* bäst att ta med en Player-klass i diagrammet för att tydligare förstå hur väl strukturen för Inventory skulle gå att använda i nästa skede.
* För del 2 av uppgiften valde jag att skapa även en Shop-klass, för att se hur Inventory skulle kunna användas av både en player och en shop (och menyer för shop + player). 
* (Just nu equippas items via "view inventory" och unequippas via "manage equipment", om man vill testa den funktionen. Buy (och sell) items i shop för att kunna use/equip/unequip.
* Bara en av otaliga saker som skulle kunna hanteras betydligt bättre. :))

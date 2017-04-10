There were many things that we refactored.  This is a list of all.

# `clanmelee.Clan2.Clan2.java`
We added a private helper method in the class called `addMembers()` to facilitate the function of the class without having as much duplicate code.  This was a small smell, but it was worth it to shorten the class and the method.

# `clanmelee.*.java`
Most names of classes were changed to other names to help us understand things better.  This wasn't necessary smelly code for most (except maybe `ClanMelee.java` being named the same as the package), but was more for our understanding of the code and making it slightly more easier to comprehend.

# `clanmelee.ClanWins.java`
The class `ClanWins.java` was moved into `Wins.java` (previously `ClansWins.java`) as the only class that utilizes it was `Wins.java` and could be encapsulated within the class to manage small amounts of information.  This was, again, more for understanding so there weren't two similarly-named classes.

# `clanmelee.ClanMelee.java`
The class `Melee.java` (previously `ClanMelee.java`) was edited heavily.  The original method was about 100 lines of code long, and there was a lot of simplification that could be done.

A method should only do one job, so that is what we set out to change.  The following gives our reasoning, and note the lack of "and" used, indicating the methods have been shortened to do only one job.

## Constructor
To make the class more object-like, we made it into more of a class with global variables and a constructor.  This has to be rewritten every round, but it was worth it even if it uses somewhat more memory, if even.

## Method `runRound()`
When `runRound()` is called, it itself calls methods of its own to run a round and return the results we need.  It only deals with a round overall.

### Method `addParticipants()`
All `addParticipants()` does is add participants to the round by modifying the `Statistics` object if the clans are validated.

#### Method `validateClan()`
`validateClan()` determines if a clan can participate.

### Method `runTurn()`
Every iteration, `runTurn()` will run every interaction to determine who is currently alive.

#### Method `runInteraction()`
`runInteraction()` runs an interaction between 2 members by `applyAction()`.

##### Method `applyAction()`
`applyAction()` runs what one participant will do to the other.

#### Method `runLastInteraction()`
`runLastInteraction()` deals with the case when there is an odd number of members.

### Method `getRemaining()`
`getRemaining()` returns who survived everything that happened during the turn.

### Method `getCurrentlyAlive()`
`getCurrentlyAlive()` checks which clans are able to continue.

### Method `checkWinners()`
`checkWinners()` determines if someone is victorious or not.

## Method `printStats()`
`printStats()`, well, prints out the statistics.
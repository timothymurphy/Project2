**Start of Round:**

- All players submit their clans, which include a collection of clan members that will participate in the melee.
- All clans are validated according to the following parameters: Each clan member must share the same clanID (an integer ID corresponding to each clan). Each clan’s members hitpoints summed must not exceed the allotted hitpoints for that round.
- When all clans and clan members have been validated we begin the first turn, and proceed taking turns until one or fewer clans remain.

**Turn:**

- The participants of the melee are shuffled in order, then the top 2 participants face each other in combat.
- This proceeds until all participants have taken action, or until only one participant remains.

**Combat:**

- In combat each participant first decides the number of action points they would like to spend on the current interaction. **There are 10 free action points that may be spent, any extra will incur an iteration damage penalty equal to the difference between action points spent and free action points minus 1, divided by the number of action points per iteration damage plus 1. This equates to 1 point of damage for every 2 action points one spends past 10.** 
- Each participant also suffers a minus 1 to their maximum hit points when deciding their action points.
- After action points are decided and iteration damage penalties have been applied, each participant is able to spend those points against the other participant. If the acting participant is a healer, they are only able to heal their opponent. If the opposing participant runs away (spends 0 action points), they will still be healed by a healer, but have a 50/50 chance of being hit by an enemy warrior. Acting warriors may only attempt to damage their opponents or run (just as healers could only heal or run). 
- After each round of combat if there is an odd number of participants, the last participant will incur a minus 1 to their max hitpoints through iteration damage. (All participants lose 1 max hp every turn).
- Once a turn has resolved, all dead participants are removed, and the next turn begins. 
- Play ends (as mentioned) when one or fewer clans remain. The remaining clan is determined as winner, and if there are no clans left, no one wins. (Winning clan is determined by highest remaining health among clans, but if we are checking for winners we only have 1 or less clans.)

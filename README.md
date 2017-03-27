# Project #1 - Clan Melee

## Goals

There are several goals for this project:

* Get more experience programming to an interface.
* See examples of the Factory Method and Strategy patterns.
* Design your own section of a larger code base.
* Become more comfortable with git.

## Program Overview

### Clan Member Factories

Each of you will write code to implement a unique clan. Your clan members will
be made accessible to the program through a factory method. You will need to
extend the abstract class `Clan` by implementing the `getClanMembers()`
method. The constructor to your factory needs to take a clan ID (as an
int). The `getClanMembers()` method takes an integer number of hit points as a
parameter. Your method should distribute these hit points over some number of
clan members, and return them as some sort of `Collection<ClanMember>`.

### Clan Members

All clan members have a current number of hit points and a maximum number of
hit points. After each interaction, the maximum number of hit points will be
reduced by 1. If the `ClanMember` has more than the maximum number of hit
points, the current hit points will be reduced to the maximum. The initial
maximum hit points for a clan member is capped at 1000.

There are two types of clan members: warriors and healers. When one of your
clan members interacts with another participant of the melee, the
`decideActionPoints()` method will be called. This provides your `ClanMember`
with the type, clan ID, current number of hit points, and current maximum
number of hit points of the other `ClanMember` in the
interaction. `decideActionPoints()` then returns the number of action points to
perform this interaction.

`decideActionPoints()` relies on an `ActionPointDecider` object to get the
number of action points to perform. The `ClanMember` constructor requires an
`ActionPointDecider` reference to be passed in through the contructor. The
`ActionPointDecider` interface also has a method called `decideActionPoints()`
which is passed references to both `ClanMember` objects involved in an
interaction. You will implement a clan member's strategy in this method.

There are several ways you can represent different kinds of clan members. It
may be easier to organize your code if you create superclasses that extend
`ClanMember` which set up a specific type of clan member in the contructor.

### Action Points

A `ClanMember` may perform a veriable number of action points during an
interaction. 0 or a negative number of action points corresponds with running
away. Positive non-zero action points performed correspond to damage from a
warrior or heal points from a healer.

Any warrior or healer may perform up to 10 action points with no
penalty. However, additional action points will cost a penalty in hit
points. A `ClanMember` may perform 2 additional action points for each penalty
point taken. For example, 11 or 12 action points cost 1 penalty hit point, 13 or
14 action points cost 2 penalty hit points, etc.

### Melee Action

During each round of a melee, participants (individual clan members) will be
randomly paired up with one another. If there are an odd number of
participants, one random participant will sit the round out.

Each pair will interact. Each participant of each interaction will know the
type, clan ID, number of hit points, and maximum number of hit points of the
other participant. Each clan member must decide how many action points to
perform.

If both participants perform positive, non-zero action points then the points
will be dealt as damage or heal points accordingly. If one participant runs
away (performs 0 or negative action points) from a warrior, and the warrior
performed positive, non-zero action points, then there is a 50/50 chance that
the damage will be dealt. If one participant runs away from a healer, all heal
points are still applied.

If a participant's hit points fall to 0 or less after an interaction, that
participant is eliminated and removed from the game. If at any point all
remaining participants are from the same clan, that clan wins.

### Rounds

For the final evaluation, 30 rounds of melees will be run. For each of the
following total hit point values there will be 5 rounds:

* 100
* 1,000
* 10,000
* 100,000
* 1,000,000
* 10,000,000

Each round's actual hit points will be +/- 5% of the base hit point value. For
example, each 100 round will have actual total hit points between 95 and 105.

Each round will have 0 or 1 winner (it is possible for everyone to be
eliminated). After all 30 rounds the clans will be ranked by number of
wins. The top 3 clans will receive a small bonus for the project: 3 points to
the top clan, 2 to the second, and 1 to the third.

## Requirements

### Clan Members

Your clan must contain at least four different kinds of clan members. Make at
least 2 types of healers and 2 types of warriors.

### Factories

You need at least 1 factory to provide the program with your clan
members. However, if the code for your factory becomes too complicated, you may
want to break it up into a heirarchy of factories, each of which produces a
different type of `ClanMember` and/or `ActionPointDecider`. If you have
multiple factories, you still need 1 main factory that returns all of the
created clan members.

### Unit Tests

Write unit tests for your classes. Be sure to test boundary conditions.

### git

Using git encourages you to think incrementally when you code. Commit to your
git repository regularly as you work. Good times to commit are when you have
added a new class, added methods to an existing class, or added new unit tests
that now pass.

After you clone this repository, create a bare repository on groot called
`~/git/ClanMelee.git` to push to. You do not need to push after every commit,
but it is recommended so that you always have a backup.

When it comes time to run the project with everyone's code combined, I will
pull your code from your bare repository on groot.

### UML Diagrams

Create UML diagrams for your classes with appropriate connectors.

### Packages

Put all your code in a package called `clanmelee.<your last name>`. Do not edit
any of the code in the `clanmelee` package.

## Grading

20% of your grade for this project will be based on whether or not your code
works correctly (compiles, does not crash, provides clan members via a
`ClanMemberFactory`, doesn't "cheat" on purpose or accidentally).

The rest of the grade will given for good design, coding style, unit tests, and
use of git.

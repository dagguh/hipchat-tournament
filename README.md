# Tournaments for HipChat

## [Swiss pairings](https://en.wikipedia.org/wiki/Swiss-system_tournament)

`/tournaments`
> Available commands:
* match
* round
* score
* tournament

`/tournament`
> Available `/tournament` sub-commands:
* create
* set
    * players
    * title
* show
* start
* use
    * swiss

`/tournament create`
> Tournament `T1` created.

`/tournament set title Netrunner Draft #5`
> Tournament `T1` title set.

`/tournament set players Alice Bob Carol Dave Eve Frank Grace`
> Tournament `T1` players set.

`/tournament show`
> Tournament `T1` "Netrunner Draft #5" has not started yet.

> Participants: Alice, Bob, Carol, Dave, Eve, Frank, Grace.

> It uses no system.

> It is the current tournament.

`/tournament use swiss`
> Tournament `T1` set to use Swiss Pairings.

`/tournament show`
> Tournament `T1` "Netrunner Draft #5" has not started yet.

> Participants: Alice, Bob, Carol, Dave, Eve, Frank, Grace.

> It uses Swiss pairings. Number of rounds: 3. Time for each round: 30 minutes. Byes are worth 2 points.

> It is the current tournament.

`/tournament`
> Available `/tournament` sub-commands:
* create
* set
    * bye-points
    * players
    * rounds
    * round-time
    * title
* show
* start
* use
    * swiss

`/tournament set rounds 2`
> Tournament `T1` number of rounds set.

`/tournament set round-time PT65M`
> Tournament `T1` time per round set.

`/tournament set bye-points 4`
> Tournament `T1` points for bye set.

`/tournament start`
> Tournament `T1` started. It can no longer be edited.

`/tournament show`
> Tournament `T1` "Netrunner Draft #5" has started on 2016-05-16 17:35.

> Participants: Alice, Bob, Carol, Dave, Eve, Frank, Grace.

> It uses Swiss pairings. Number of rounds: 2. Time for each round: 65 minutes. Byes are worth 4 points.

> It is the current tournament.

`/round add`
> Round `T1R1` added.

> Matches to play:
* `T1R1G1: Alice vs Dave`
* `T1R1G2: Carol vs Eve`
* `T1R1G3: Frank vs Bob`

> Bye given to Grace. An odd number of players results in a bye for a random lowest-ranked player.

`/round start`
> Round `T1R1` started. It will end on 18:40.

`/match score Carol Eve 0:2`
> Match `T1R1G2` recorded.

`/round add`
> Round `T1R2` cannot be added until `T1R1` finishes:
* `T1R1G1: Alice vs Dave`
* `T1R1G3: Frank vs Bob`

`/round start`
> Round `T1R1` is already started.

`/match score Alice Bob 2:2`
> These opponents should not play against each other this round. Command ignored.

`/match score Carol Eve 2:2`
> Match `T1R1G2` updated.

`/match show G1`
> Match `T1R1G1: Alice vs Dave` was not played yet.

`/match show G2`
> Match `T1R1G2: Carol vs Eve 2:2` was played.

`/match score Alice Dave 4:0`
> Match `T1R1G1: Alice vs Dave 4:0` recorded.

_65 minutes pass ..._

> Round `T1R1` timed out. The following matches should be timed out:
* `T1R1G3: Frank vs Bob`

`/match score Bob Frank 1:2`
> Match `T1R1G3: Frank vs Bob 2:1` recorded.

> Round `T1R1` finished.

`/score`
> `T1` current standings:
* Alice: 4
* Grace: 4
* Carol: 2
* Eve: 2
* Frank: 2
* Bob: 1
* Dave: 0

`/round start`
> Round `T1R2` started. It will end on 19:50.

> Matches to play:
* `T1R2G1: Alice vs Grace`
* `T1R2G2: Carol vs Frank`
* `T1R2G3: Bob vs Eve`

> Bye given to Dave. An odd number of players results in a bye for a random lowest-ranked player.

`/match score Bob Eve 2:2`
> Match `T1R2G3` recorded.

`/match score Alice Grace 4:0`
> Match `T1R2G1` recorded.

`/match score Carol Frank 0:4`
> Match `T1R2G2` recorded.

> Round `T1R2` finished.

> Tournament `T1` finished.

`/score`
> `T1` current standings:
* Alice: 8
* Frank: 6
* Dave: 4
* Eve: 4
* Grace: 4
* Bob: 3
* Carol: 2

# Development

## Assumptions
The environment either has Docker or a useful `JDBC_DATABASE_URL` variable

## Lack of transparency
Unfortunately, currently the local dev loop is not transparent.
You need to run with the magical `keep-jetty` Maven profile and then you'll be able to run tests from IntelliJ.
You'll have to clean up the Docker container as well.
Automatic periodic reloading has a delay.

## Gotchas

* Jackson deserialization needs one of:
  * a type with `@JsonProperty` annotated constructor
  * a mutable type with a no-arg constructor

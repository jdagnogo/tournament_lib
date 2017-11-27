# tournament_lib

an Android lib that creates a tournament view.
Feel free to send me suggestions or improvements  : jdagnogo11@gmail.com

-----------------------------------------------------------------------------------------------------------------------------

# Presentation : 

 <img src="https://github.com/jdagnogo/tournament_lib/blob/master/screenshots/logo.png" width="300" style=" float : left;">
 
This application allows you to :
  * create a tournament view
  * get all the results
  

# Screenshots : 

init view

<img src="https://github.com/jdagnogo/tournament_lib/blob/master/screenshots/Screenshot_2017-11-14-15-43-32.png" width="300" style=" float : left;">

You will have a nice display and you can get all results programmatically.

<img src="https://github.com/jdagnogo/tournament_lib/blob/master/screenshots/Screenshot_2017-11-14-15-43-47.png" width="300" style=" float : left;">

You can change the score with the EditText and all results will be adjusted.

<img src="https://github.com/jdagnogo/tournament_lib/blob/master/screenshots/Screenshot_2017-11-14-16-19-21.png" width="300" style=" float : left;">

You can zoom

<img src="https://github.com/jdagnogo/tournament_lib/blob/master/screenshots/Screenshot_2017-11-14-15-44-26.png" width="300" style=" float : left;">

(Yes i am an Arsenal fan ^^ COYG !)

-----------------------------------------------------------------------------------------------------------------------------
# How to install :

```
		allprojects {
						repositories {
							...
							maven { url 'https://jitpack.io' }
						}
					}

					
		compile 'com.github.jdagnogo:tournament_lib:1.0'
```

# How to use :

Create all teams
```
		arsenal = new Team("Arsenal");
        real = new Team("Real Madrid");
        milan = new Team("Milan AC");
        psg = new Team("PSG");
```

        allTeam = new ArrayList<>();
        allTeam.add(arsenal);
        allTeam.add(real);
        allTeam.add(milan);
        allTeam.add(psg);
 ```       
    tournamentView.setTournament(new Tournament(allTeam));
                tournamentView.startTournament();
```
Then you can set score thanks to the edit text

Or if you already have all the results you can create all games and then simulate the tournament
```
                // create all games
                Match semiA = new Match.MatchResultBuilder(arsenal, real).currentPosition(TournamentRound.SemiA).scoreA(5).scoreB(0).build();
                Match semiB = new Match.MatchResultBuilder(milan, psg).currentPosition(TournamentRound.SemiB).scoreA(4).scoreB(3).build();
                Match finalMatch = new Match.MatchResultBuilder(arsenal, milan).currentPosition(TournamentRound.Final).scoreA(4).scoreB(0).build();


                // Create a tournament
                Tournament championLeague = new Tournament.TournamentBuilder(allTeam).addMatch(semiA).addMatch(semiB).build();
                
                //you can also add a match after the tournament was created
                championLeague.addMatch(finalMatch);

                tournamentView.setTournament(championLeague);
                tournamentView.startTournament();
                //use simulate to have the display
                tournamentView.simulate();

```				
# libs used:
```
-IcePick
-Butterknife
-zoomlayout
```
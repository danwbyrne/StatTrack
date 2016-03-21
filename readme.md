TO CLEAR UP CLUTTER IN CLASS FILES IM GOING TO PUT SOME NOTES HERE

---------
| Entry |
---------
Entry is a class that stores a Calendar instance and some T quantity
(T extends Number). I don't know what kind of data type we want to use
so I'll just leave it generic for now. The generics cause some issues
with return casts in Table.

Entries implements Comparable, its compareTo and equals methods of that
are wrappers to those of Calendar.

compareTime allows you to check if this entry has the same field
as an input Calendar instance. Might consider making this less generic
and splitting it into more than one method for ease.
Some Calendar Field examples to compare are:

	DAY_OF_WEEK, DAY_OF_MONTH, WEEK_OF_MONTH
	MONTH, HOUR, ERA (kappa), DAY_OF_YEAR

you can find more in the Calendar Docs.

Methods: (just for doc ease)
	getData() //gets data
	getCalendar() //gets Calendar
	compareTime(Calendar t, int field) //checks filter

Ideas:
	- implement data so that it can be more broad. Possibly
	  make a data class, more on this later.



-----------
|  Table  |
-----------
Table is a class that stores Entry instances. This will be one of
the main classes used, it will handle calculating the statistics
of the entries in it.

timeFilter returns a new table of entries that pass the given
Calendar filter field.
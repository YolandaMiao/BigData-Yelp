## Load Yelp Json Data By MapReduce
**Use command:** 

- `cd JsonLoader`
- `mvn clean package`
- `sudo -u hdfs hdfs dfsadmin -safemode leave`
- `hdfs dfs -mkdir -p yelpMR/input/review`
- `hdfs dfs -put /home/cloudera/Yolanda/MapReduce/review_smallset.json /user/cloudera/yelpMR/input/review`
- `hadoop jar JsonLoader-0.0.1-SNAPSHOT.jar mapreduce.LoaderDemo /user/cloudera/yelpMR/input/review /user/cloudera/yelpMR/output/review`

**Example output demo:**

...

1uJFq2r5QfJG_6ExMRCaGw	General Manager Scott Petello is a good egg!!! Not to go into detail, but let me assure you if you have any issues (albeit rare) speak with Scott and treat the guy with some respect as you state your case and I'd be surprised if you don't walk out totally satisfied as I just did. Like I always say..... "Mistakes are inevitable, it's how we recover from them that is important"!!!

Thanks to Scott and his awesome staff. You've got a customer for life!! .......... :^) funny is 0 useful is 0 cool is 0









...


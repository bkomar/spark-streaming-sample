CREATE KEYSPACE click_stream WITH replication = {'class':  'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE click_stream.user_clicks (
  user_id text,
  session_id text,
  url text,
  clicks int,
  PRIMARY KEY (user_id, session_id, url)
);
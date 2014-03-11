-- name: create-log-table!
CREATE TABLE log (
		uri VARCHAR(200),
		time DATE
)

-- name: current-database-time
SELECT current_timestamp AS time
FROM sysibm.sysdummy1

-- name: insert-log!
INSERT INTO log (uri, time) VALUES (:uri, :time)

-- name: fetch-logs
SELECT *
FROM log

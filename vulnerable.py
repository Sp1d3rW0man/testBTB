import sqlite3
import os

# SQL Injection vulnerability
def unsafe_sql_query(user_input):
    conn = sqlite3.connect('example.db')
    cursor = conn.cursor()
    query = "SELECT * FROM users WHERE name = '{}'".format(user_input)
    cursor.execute(query)
    result = cursor.fetchall()
    conn.close()
    return result

# Hardcoded credentials
def connect_db():
    conn = sqlite3.connect('example.db', user='admin', password='password')
    return conn

# Command Injection vulnerability
def unsafe_command_execution(user_input):
    os.system("ls {}".format(user_input))

user_input = "admin' OR '1'='1"
print(unsafe_sql_query(user_input))
print(unsafe_command_execution(user_input))

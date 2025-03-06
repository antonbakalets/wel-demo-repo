# login as apiuser
curl -X POST \
  --header 'Content-Type: application/json' \
  --data '{"username": "apiuser", "password": "password123"}' \
http://localhost:8080/api/login

# login as uiuser
curl -X POST \
  --header 'Content-Type: application/json' \
  --data '{"username": "uiuser", "password": "password123"}' \
http://localhost:8080/api/login

# check employee eligibility
curl -X POST \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1aXVzZXIiLCJyb2xlcyI6IlVJX1VTRVIiLCJpYXQiOjE3NDEyOTM1OTQsImV4cCI6MTc0MTI5NDQ5NH0.mzRv_BfGSa0A9BDVs2LB1X7rtS35s5pdTfxqvSNClHo' \
  --data '{"employee_code": "group1", "member_status": "employee", "employee_id": "e2346", "employee_date_of_birth": "1998-09-05"}' \
http://localhost:8080/api/eligibility/verify

# check dependent eligibility
curl -X POST \
  --header 'Content-Type: application/json' \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhcGl1c2VyIiwicm9sZSI6IkFQSV9VU0VSIiwiaWF0IjoxNzQxMjkyNjI2LCJleHAiOjE3NDEyOTM1MjZ9.6eCrqBbY0E43SKA94NMvejPcNP45-cMNSc8wi-eCTb8' \
  --data '{"employee_code": "group1", "member_status": "dependent", "employee_first_name": "Rik", "employee_last_name": "Second", "employee_date_of_birth": "1998-09-05"}' \
http://localhost:8080/api/eligibility/verify
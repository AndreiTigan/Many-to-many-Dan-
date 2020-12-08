
CREATE TABLE IF NOT EXISTS INTERNSHIPS
  (
  INTERN_ID int NOT NULL,
  COMPANY_ID int NOT NULL,
  START_DATE timestamp,
  END_DATE timestamp,
  PRIMARY KEY (INTERN_ID, COMPANY_ID),
  FOREIGN KEY (INTERN_ID) REFERENCES INTERNS(ID),
  FOREIGN KEY (COMPANY_ID) REFERENCES COMPANIES(ID)

);






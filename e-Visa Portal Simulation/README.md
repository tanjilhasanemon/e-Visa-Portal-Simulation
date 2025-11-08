# 🌐 eVisaPortal-Simulation

A simple **Java + JavaFX (FXML)** project that simulates core operations of an **e-Visa Management Portal**.  
Designed for an OOP course project to demonstrate role-based workflows, FXML UI design, and event-driven actions — all using in-memory data (no external DB).

---

## 🚀 Project Overview
This project models an e-Visa portal in a simplified, offline form.  
Each user role performs small, clearly defined tasks through JavaFX screens (FXML). The goal is to keep the system simple and easy to implement using SceneBuilder + controller classes.

---

## 👥 User Roles (final)
- **User-1: Applicant**  
- **User-2: Registered Agent**  
- **User-3: Visa Officer**  
- **User-4: Issuer**  
- **User-5: Operations Manager**  
- **User-6: Policy Manager**  
- **User-7: Finance Clerk**  
- **User-8: Support Agent**

> Each team member implements two users (8 goals per user) as per project plan.

---

## 🧩 Key Features (example)
- Common authentication screens (Sign In / Log In / Forgot Password)
- Role-specific dashboards (Applicant, Registered Agent, Visa Officer, etc.)
- Basic workflows: submit application, upload documents, review, recommend/forward, renew/cancel, issue e-Visa
- Simple in-memory storage using Java collections (`ObservableList`, `ArrayList`)
- FXML views designed with SceneBuilder; controllers connect UI → model

---

## 🧱 Technology Stack
- Java (JDK 23)  
- JavaFX (FXML)  
- SceneBuilder (for FXML)  
- Git + GitHub for version control

---

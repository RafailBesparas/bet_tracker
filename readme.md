# 🏆 Bet Tracking & Analysis Tool

A practical Java Spring Boot web application for tracking and analyzing sports bets, inspired by real-world use cases like **Betting or tracking**. This project allows users to add, manage, and analyze their betting history, all through a clean REST API and simple HTML frontend.

---

## 📌 Features

- ✅ Add/view/edit/delete bets via REST API
- 📊 View all bets in a dynamic HTML table
- 💸 Calculate total profit/loss based on stake and odds
- 🔍 Filter bets by sport, outcome, or odds
- 🧾 HTML landing page to submit new bets
- 🚀 Built with Spring Boot and Vanilla JavaScript

---

## 🧱 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Web
- HTML/CSS + Vanilla JavaScript
- In-memory data store (Java List)
- REST API (JSON)

---

## 🚀 How to Run the Project

### 1. Clone the repository
```bash
git clone https://github.com/RafailBesparas/bet_tracker.git
cd bet_tracker
```

### 2. Run with Maven
```bash
./mvnw spring-boot:run
```

### 3. Access the app
- API: `http://localhost:8080/api/bets`
- Add bets: `http://localhost:8080/add_bet.html`
- View bets: `http://localhost:8080/my_bets.html`

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/dev/devbesparas/runnerz/
│   │   ├── Application.java
│   │   └── bet/
│   │       ├── Bet.java
│   │       ├── BetController.java
│   │       └── BetRepository.java
│   └── resources/
│       ├── static/
│       │   ├── add_bet.html
│       │   └── my_bets.html
│       └── application.properties
```

---

## 📬 Example API Usage

### ✅ Add a Bet
```http
POST /api/bets
Content-Type: application/json

{
  "id": 1,
  "sport": "Football",
  "team": "FC Bayern Munich",
  "date": "2025-04-08",
  "stake": 50.0,
  "odds": 2.5,
  "won": true
}
```

### 📈 View Profit/Loss
```http
GET /api/bets/profit
```

### 🔄 View All Bets
```http
GET /api/bets
```

---

## ✨ Future Enhancements
- ✅ Connect to a real database (H2/PostgreSQL)
- 📤 CSV Export for betting history
- 📅 Filter by date range
- 📊 Chart visualizations (wins/losses per sport)
- 🔐 User login system with sessions

---

## 🧑‍💻 Author
**Rafail Besparas**  
[GitHub Profile](https://github.com/RafailBesparas)

---

## 📄 License
This project is licensed under the MIT License.

---

Happy betting & better tracking! 🎯

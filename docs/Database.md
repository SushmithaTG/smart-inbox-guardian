# Database Design

## Table 1: users
| Column | Type | Notes |
|---|---|---|
| id | BIGINT | Primary Key, Auto Increment |
| name | VARCHAR(100) | Full name |
| email | VARCHAR(150) | Unique, used for login |
| password | VARCHAR(255) | Encrypted |
| created_at | DATETIME | Auto-filled |
 | updated_at | DATETIME | Auto-updated when record changes |

## Table 2: gmail_accounts
| Column | Type | Notes                                   |
|---|---|-----------------------------------------|
| id | BIGINT | Primary Key                             |
| user_id | BIGINT | Links to users table                    |
| gmail_email | VARCHAR(150) | Connected Gmail address                 |
| access_token | TEXT | Google API token                        |
| created_at | DATETIME | Auto-filled                             |
 |is_active | BOOLEAN | true = connected, false = disconnected| 

## Table 3: emails
| Column           | Type | Notes |
|------------------|---|---|
| id               | BIGINT | Primary Key |
| gmail_account_id | BIGINT | Links to gmail_accounts |
| sender           | VARCHAR(200) | Who sent it |
| subject          | VARCHAR(500) | Email subject |
| body_preview     | TEXT | First 500 characters |
| received_at      | DATETIME | When it arrived |
| is_important     | BOOLEAN | AI flagged? true/false |

## Table 4: classifications
| Column | Type | Notes |
|---|---|---|
| id | BIGINT | Primary Key |
| email_id | BIGINT | Links to emails table |
| category | VARCHAR(50) | Interview/Offer/Assessment etc |
| summary | TEXT | AI generated summary |
| action_required | TEXT | What user should do |
| confidence | DECIMAL | AI confidence % |
| created_at | DATETIME | Auto-filled |

## Table 5: notifications
| Column | Type | Notes |
|---|---|---|
| id | BIGINT | Primary Key |
| user_id | BIGINT | Links to users table |
| email_id | BIGINT | Links to emails table |
| type | VARCHAR(20) | email/browser/push |
| sent_at | DATETIME | When alert was sent |
| is_read | BOOLEAN | Seen by user? true/false |
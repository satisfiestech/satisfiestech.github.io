# Security Guide

## Environment Variables

This project uses environment variables to store sensitive data. Never commit actual credentials to version control.

### Setup Instructions

1. **Copy the example file:**
   ```bash
   cp .env.example .env
   ```

2. **Update `.env` with your actual credentials:**
   - `DATABASE_URL` - Your database connection string
   - `DATABASE_USERNAME` - Database username
   - `DATABASE_PASSWORD` - Database password
   - `ADMIN_USERNAME` - Admin panel username
   - `ADMIN_PASSWORD` - Admin panel password

3. **Run the application:**
   
   **Windows:**
   ```cmd
   run.bat
   ```
   
   **Or manually set variables:**
   ```cmd
   set DATABASE_URL=jdbc:postgresql://db.jpfimgzekvkgatlwysxq.supabase.co:5432/postgres?sslmode=require
   set DATABASE_USERNAME=postgres
   set DATABASE_PASSWORD=your_password
   set ADMIN_USERNAME=admin
   set ADMIN_PASSWORD=your_admin_password
   set SERVER_PORT=9090
   set CORS_ORIGINS=https://satisfiestech.github.io
   set SHOW_SQL=false
   mvn spring-boot:run
   ```
   
   **Linux/Mac:**
   ```bash
   export $(cat .env | xargs) && mvn spring-boot:run
   ```

### Docker Setup

Set environment variables in `docker-compose.yml`:

```yaml
environment:
  DATABASE_URL: ${DATABASE_URL}
  DATABASE_USERNAME: ${DATABASE_USERNAME}
  DATABASE_PASSWORD: ${DATABASE_PASSWORD}
```

Or use `.env` file with Docker Compose (it will automatically load).

### Production Deployment

For production, set environment variables in your hosting platform:
- **Heroku:** `heroku config:set DATABASE_URL=...`
- **AWS:** Use AWS Secrets Manager or Parameter Store
- **Azure:** Use Azure Key Vault
- **Docker:** Use secrets or environment variables

## Security Best Practices

✅ **DO:**
- Use strong passwords (min 12 characters, mixed case, numbers, symbols)
- Rotate credentials regularly
- Use different credentials for dev/staging/production
- Enable SSL/TLS for database connections
- Keep dependencies updated

❌ **DON'T:**
- Commit `.env` file to Git
- Share credentials in chat/email
- Use default passwords in production
- Expose admin endpoints publicly
- Log sensitive data

## Reporting Security Issues

If you discover a security vulnerability, please email: security@satisfiestech.com

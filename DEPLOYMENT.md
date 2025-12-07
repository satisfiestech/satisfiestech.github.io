# Deployment Guide

## Architecture

- **Frontend**: Vercel (Static HTML/CSS/JS)
- **Backend**: Railway/Render/Heroku (Spring Boot API)
- **Database**: Supabase (PostgreSQL)

---

## 🚀 Deploy Backend (Railway - Recommended)

### 1. Install Railway CLI
```bash
npm install -g @railway/cli
```

### 2. Login to Railway
```bash
railway login
```

### 3. Initialize Project
```bash
railway init
```

### 4. Add Environment Variables
```bash
railway variables set DATABASE_URL="jdbc:postgresql://db.jpfimgzekvkgatlwysxq.supabase.co:5432/postgres?sslmode=require"
railway variables set DATABASE_USERNAME="postgres"
railway variables set DATABASE_PASSWORD="JqyOg13TEBncgF2Z"
railway variables set ADMIN_USERNAME="admin"
railway variables set ADMIN_PASSWORD="admin123"
railway variables set SERVER_PORT="8080"
railway variables set CORS_ORIGINS="https://your-vercel-app.vercel.app"
railway variables set SHOW_SQL="false"
```

### 5. Deploy
```bash
railway up
```

### 6. Get Your Backend URL
```bash
railway domain
```
Copy the URL (e.g., `https://satisfiestech-production.up.railway.app`)

---

## 🌐 Deploy Frontend (Vercel)

### 1. Install Vercel CLI
```bash
npm install -g vercel
```

### 2. Login to Vercel
```bash
vercel login
```

### 3. Update vercel.json
Replace `your-backend-url.railway.app` with your actual Railway URL in `vercel.json`

### 4. Deploy
```bash
vercel --prod
```

---

## 🔄 Alternative: Deploy Backend to Render

### 1. Go to https://render.com
### 2. Click "New +" → "Web Service"
### 3. Connect your GitHub repository
### 4. Configure:
   - **Name**: satisfiestech-api
   - **Environment**: Java
   - **Build Command**: `mvn clean package -DskipTests`
   - **Start Command**: `java -jar target/*.jar`
   - **Instance Type**: Free

### 5. Add Environment Variables:
   - `DATABASE_URL`
   - `DATABASE_USERNAME`
   - `DATABASE_PASSWORD`
   - `ADMIN_USERNAME`
   - `ADMIN_PASSWORD`
   - `SERVER_PORT=8080`
   - `CORS_ORIGINS`

### 6. Click "Create Web Service"

---

## 🔄 Alternative: Deploy Backend to Heroku

### 1. Create Procfile
```
web: java -jar target/*.jar
```

### 2. Deploy
```bash
heroku create satisfiestech-api
heroku config:set DATABASE_URL="jdbc:postgresql://..."
heroku config:set DATABASE_USERNAME="postgres"
heroku config:set DATABASE_PASSWORD="..."
git push heroku main
```

---

## 📝 Update Frontend API Calls

After deploying backend, update your frontend JavaScript files to use the backend URL:

```javascript
// In site/js/products.js or similar
const API_URL = 'https://your-backend-url.railway.app/api';

async function loadProducts() {
  const response = await fetch(`${API_URL}/products`);
  const products = await response.json();
  // ...
}
```

---

## ✅ Verify Deployment

1. **Backend**: Visit `https://your-backend-url.railway.app/api/products`
2. **Frontend**: Visit your Vercel URL
3. **Test**: Try adding products, viewing cart, etc.

---

## 🔒 Security Checklist

- ✅ Environment variables set on hosting platform
- ✅ CORS configured with frontend URL
- ✅ Database password is strong
- ✅ Admin password is changed from default
- ✅ SSL/TLS enabled (automatic on Railway/Vercel)
- ✅ `.env` file not committed to Git

---

## 📊 Monitoring

- **Railway**: https://railway.app/dashboard
- **Vercel**: https://vercel.com/dashboard
- **Supabase**: https://app.supabase.com

---

## 🆘 Troubleshooting

### Backend not connecting to database
- Check environment variables are set correctly
- Verify Supabase database is active
- Check Railway/Render logs

### CORS errors
- Update `CORS_ORIGINS` environment variable with your Vercel URL
- Restart backend service

### Frontend not loading
- Check Vercel deployment logs
- Verify `vercel.json` configuration
- Clear browser cache

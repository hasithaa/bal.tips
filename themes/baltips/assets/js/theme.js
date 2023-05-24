document.addEventListener('DOMContentLoaded', () => {
    const searchBtn = document.getElementById('search-btn');
    const searchInput = document.querySelector('input[type="search"]');
    
    searchBtn.addEventListener('click', (event) => {
      event.preventDefault();
      const searchQuery = searchInput.value;
      const searchUrl = new URL('/search', window.location.href);
      searchUrl.searchParams.set('q', searchQuery);
      window.location.href = searchUrl.href;
    });
    
    const agreeButton = document.getElementById('ga-agree-button');
    const declineButton = document.getElementById('ga-decline-button');

    const privacyNotice = document.getElementById('privacyNotice');

    // Check if the user has already agreed to the privacy notice
    if (localStorage.getItem('privacyNoticeAgreed')) {
        privacyNotice.classList.add('d-none');
        if (localStorage.getItem('privacyNoticeAgreed') === 'true') {
            // Enable Google Analytics
            window['ga-disable-GA_MEASUREMENT_ID'] = false;
        } else {
            // Disable Google Analytics
            window['ga-disable-GA_MEASUREMENT_ID'] = true;
        }
    } else {
        privacyNotice.classList.remove('d-none');
    }

    agreeButton.addEventListener('click', () => {
        // Enable Google Analytics
        window['ga-disable-GA_MEASUREMENT_ID'] = false;

        // Hide the privacy notice section
        privacyNotice.classList.add('d-none');

        // Remember the user's choice for 1 day
        localStorage.setItem('privacyNoticeAgreed', 'true');
        setTimeout(() => {
            localStorage.removeItem('privacyNoticeAgreed');
        }, 24 * 60 * 60 * 1000 * 7); // 7 day in milliseconds
    });

    declineButton.addEventListener("click", () => {
        // Disable Google Analytics
        window['ga-disable-GA_MEASUREMENT_ID'] = true;

        // Hide the privacy notice section
        privacyNotice.classList.add('d-none');

        // Remember the user's choice for 1 day
        localStorage.setItem('privacyNoticeAgreed', 'false');
        setTimeout(() => {
            localStorage.removeItem('privacyNoticeAgreed');
        }, 24 * 60 * 60 * 1000 * 7); // 7 day in milliseconds
    });

    const footerNoteXButton = document.getElementById('footer-note-x-button');
    const note = document.getElementById('footer-note');

    footerNoteXButton.addEventListener('click', () => {
        note.classList.add('d-none');
        localStorage.setItem('isNoteClosed', true);
        setTimeout(() => {
            localStorage.removeItem('privacyNoticeAgreed');
        }, 24 * 60 * 60 * 1000); // 1 day in milliseconds
    });

    if (localStorage.getItem('isNoteClosed') === 'true') {
        note.classList.add('d-none');
    } else {
        note.classList.remove('d-none');
    }
});
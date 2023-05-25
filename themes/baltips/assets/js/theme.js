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

    // Load Source Code View.
    // Get the radio buttons and the code blocks
    const radioButtons = document.querySelectorAll('input[name="source-options"]');
    const fullCodeBlock = document.querySelector('.tip-code-full');
    const simpleCodeBlock = document.querySelector('.tip-code-simple');
    const highlightCodeBlock = document.querySelector('.tip-code-highlight');

    // Get the value from local storage and set the selected radio button
    const localStorageKey = 'codeView';
    const selectedValue = localStorage.getItem(localStorageKey);
    if (selectedValue) {
        const selectedButton = document.querySelector(`input[value="${selectedValue}"]`);
        if (selectedButton) {
            selectedButton.checked = true;
        }
    }

    // Add an event listener to each radio button to toggle the visibility of the code blocks
    radioButtons.forEach(button => {
    button.addEventListener('change', () => {
        localStorage.setItem(localStorageKey, button.value);
        if (button.value === 'tip-code-full') {
            fullCodeBlock.classList.remove('d-none');
            simpleCodeBlock.classList.add('d-none');
            highlightCodeBlock.classList.add('d-none');
        } else if (button.value === 'tip-code-simple') {
            fullCodeBlock.classList.add('d-none');
            simpleCodeBlock.classList.remove('d-none');
            highlightCodeBlock.classList.add('d-none');
        } else if (button.value === 'tip-code-highlight') {
            fullCodeBlock.classList.add('d-none');
            simpleCodeBlock.classList.add('d-none');
            highlightCodeBlock.classList.remove('d-none');
        }
    });
    
    // Trigger the change event on the selected radio button to set the visibility of the code blocks
    if (button.checked) {
        button.dispatchEvent(new Event('change'));
    }
    });
});